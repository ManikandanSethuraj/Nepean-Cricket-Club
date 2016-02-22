package com.manikandansethuraj.nepeancricketclub;

/**
 * Created by ManikandanSethuraj on 2016-02-21.
 */

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by ManikandanSethuraj on 2015-11-27.
 */
public class ParseApplications {
    private  String xmlData;
    private ArrayList<Application> applications;

    public ParseApplications(String xmlData) {
        this.xmlData = xmlData;
        applications = new ArrayList<Application>();
    }

    public ArrayList<Application> getApplications() {
        return applications;
    }

    public boolean process(){
        boolean status = true;
        Application currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT){
                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        // Log.d("ParseApplications","Starting Tag for" + tagName);
                        if (tagName.equalsIgnoreCase("item")){

                            inEntry = true;
                            currentRecord = new Application();

                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;


                    case XmlPullParser.END_TAG:
                        // Log.d("parseApplications","End Tag for" + tagName);

                        if (inEntry){
                            if (tagName.equalsIgnoreCase("item")){
                                applications.add(currentRecord);
                                inEntry = false;
                            } else if (tagName.equalsIgnoreCase("title")){
                                currentRecord.setTitle(textValue);

                            }}

                        break;
                    default:
                        break;
                }
                eventType = xpp.next();
            }







        }catch (Exception e){
            status = false;
            e.printStackTrace();
        }

        for (Application app : applications){
            Log.d("ParseApplications", "***********************");
            Log.d("ParseApplications", "Name : " + app.getTitle());

        }
        return true;
    }

}
