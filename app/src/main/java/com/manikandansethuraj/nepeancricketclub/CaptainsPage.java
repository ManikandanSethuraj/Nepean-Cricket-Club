package com.manikandansethuraj.nepeancricketclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CaptainsPage extends AppCompatActivity {

    private List<ExecutiveClass> myExecutiveClass = new ArrayList<ExecutiveClass>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captains_page);

        populateExectiveList();
        populateExecutiveListView();
    }

    private void populateExectiveList(){
        myExecutiveClass.add(new ExecutiveClass("Suthan Kuhanesan","PRESIDENT",R.drawable.suthan));
        myExecutiveClass.add(new ExecutiveClass("Kogilan Ravinthiran","VICE PRESIDENT",R.drawable.kogi));
        myExecutiveClass.add(new ExecutiveClass("Udhaykiran Rangineni", "SECRETARY", R.drawable.udhay));
        myExecutiveClass.add(new ExecutiveClass("Suthershan Sundarlingam", "TREASURER", R.drawable.suthershan));
        myExecutiveClass.add(new ExecutiveClass("Anwer Omar", "TEAM MANAGER", R.drawable.anwer));
        myExecutiveClass.add(new ExecutiveClass("Jenurius mark", "SELECTOR", R.drawable.jenu));

    }

    private void populateExecutiveListView(){
        ArrayAdapter<ExecutiveClass> executiveClassArrayAdapter = new MyExecArrayAdapter();
        ListView execList = (ListView) findViewById(R.id.executiveslistView);
        execList.setAdapter(executiveClassArrayAdapter);
    }

    private class MyExecArrayAdapter extends ArrayAdapter<ExecutiveClass>{
        public MyExecArrayAdapter(){
            super(CaptainsPage.this,R.layout.executive_list_item, myExecutiveClass);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

           View itemView = convertView;
            if (itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.executive_list_item, parent, false);
            }

            ExecutiveClass currentExec = myExecutiveClass.get(position);

           ImageView exec_ImageView = (ImageView) itemView.findViewById(R.id.execImageViewListitem);
            exec_ImageView.setImageResource(currentExec.getExective_IconID());

            TextView exec_Name = (TextView)  itemView.findViewById(R.id.execNametextView);
            exec_Name.setText(currentExec.getExecutive_name());

            TextView exec_Position = (TextView) itemView.findViewById(R.id.execPositiontextView);
            exec_Position.setText(currentExec.getExecutive_Position());

            return itemView;
        }
    }
}
