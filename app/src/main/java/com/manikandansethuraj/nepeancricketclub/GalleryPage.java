package com.manikandansethuraj.nepeancricketclub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GalleryPage extends AppCompatActivity {

    private GridView gridView;
    private GridviewAdapter gridviewAdapter;


   private String[] items = {"https://scontent-ord1-1.xx.fbcdn.net/hphotos-xta1/v/t1.0-9/10885398_10153198606887087_4768276572572442542_n.jpg?oh=fbf989d46dd1e4126f0707484f99e4d9&oe=5766A864",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlf1/v/t1.0-9/11953000_10153198604292087_8443078259848898842_n.jpg?oh=ff49f49060261e7609f4bb6014965df4&oe=57274F42",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlf1/v/t1.0-9/10868062_10152662364837087_6280225970391622648_n.jpg?oh=4c102bfade5dbb7310379d73533ce75b&oe=57246703",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/10898010_10152662364217087_6870315798399195448_n.jpg?oh=279453d7c50ad63ff9c248ffe533373c&oe=57255B00",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfl1/v/t1.0-9/1463084_209107956102362_1274451301578498776_n.jpg?oh=5b349818278a775ad3d974be684c3822&oe=5724F195",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/1236000_10200556380099980_1356225052_n.jpg?oh=dad35c202303fa225407e27c8f4d5f1d&oe=575E5069",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xft1/v/t1.0-9/12540799_209107082769116_8264212235751810247_n.jpg?oh=183e2c90f0600b59e7057b15d1e42e79&oe=5727280F",
   "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-0/s370x247/12417977_209107079435783_4893715514695836167_n.jpg?oh=8130cb19aad715fd85634e1c2a761a10&oe=57248BC6",
   "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpt1/v/t1.0-9/12400947_209107132769111_2779231653425950250_n.jpg?oh=383062c3112b30dcda1c4005447962da&oe=5727BE0E",
   "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/12549101_209107139435777_9086404569472759337_n.jpg?oh=7f2e8ab6a26f329a0d43ff41ea5a1c56&oe=575AFDA1",
   "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xft1/v/t1.0-9/12553087_209107269435764_4151021314110973517_n.jpg?oh=a6fcf6c3a45b9bf3e0c1191899649074&oe=5752F55E",
   "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/12631408_209107302769094_5111223995294525982_n.jpg?oh=286dafc7e058b9f1838a4d27f5895e72&oe=575B3EF3",
   "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/12642448_209108749435616_2012371002235095426_n.jpg?oh=8812ed0e32485cb633543bd72ff4551b&oe=5754B081",
   "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfp1/t31.0-8/s960x960/12622460_209108792768945_6446780228033187129_o.jpg",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/5430_209108586102299_7142904624038027745_n.jpg?oh=f0db247ab51b88b50a85b19d195ae4e2&oe=57528962",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xla1/v/t1.0-9/12524311_209108662768958_1354086608004757456_n.jpg?oh=4cb31984ca62d8ad063fdbb93db76085&oe=575E8E1B",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xal1/v/t1.0-9/9574_209108366102321_3089158595361332204_n.jpg?oh=e9c8f02a1e3fcf2157849d232a05a263&oe=57673B0C",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/12540849_209108229435668_2137510750079330616_n.jpg?oh=e3071e44681ee1ee0ac9f03e39990c7a&oe=57597B46",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlt1/v/t1.0-9/12565397_209107382769086_4027038362644430976_n.jpg?oh=ca5863d1ab013547ba53954ab0ba4c4b&oe=5764B56A",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlp1/v/t1.0-9/12631279_209107436102414_8749326274258465786_n.jpg?oh=1f1d6bdee01bc2c8cc35ddc5fcf87c63&oe=576AF57A",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfl1/v/t1.0-9/1915313_209107469435744_6517784647393695921_n.jpg?oh=0a210a4b1d617fff4f8dce11619d7a39&oe=576C5B46",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/12642484_209107209435770_8420061240121904370_n.jpg?oh=1ec840eb63af1ad3d33b096895232cb0&oe=5728BB10",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xft1/v/t1.0-9/12592397_209107519435739_5295670489429513424_n.jpg?oh=2389dcf33153506bc13e60e30e3c01c5&oe=5769852E",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xta1/v/t1.0-9/12642648_209107282769096_5619651732130926950_n.jpg?oh=b4392f26836e7bb5724b0ad83661b1f2&oe=575D12D3",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/12552666_209107532769071_2832094751675561049_n.jpg?oh=1fadcd309aa17df1f3399eba3d3add1e&oe=576A4E9A",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/12552666_209107532769071_2832094751675561049_n.jpg?oh=1fadcd309aa17df1f3399eba3d3add1e&oe=576A4E9A",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/12552785_209107559435735_4290287549282961058_n.jpg?oh=4eedba39fe75c3ba8a4a6c2360dfc3fe&oe=5762B21A",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfp1/v/t1.0-9/12644722_209107172769107_2729792592291514043_n.jpg?oh=b84b6615884623d6b3b3258d0fa529a7&oe=5728A1D9",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpt1/v/t1.0-9/12642709_209107606102397_1167683234976125886_n.jpg?oh=edf4d42ac59568f34f90d311d97e6f67&oe=5723B377",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/12565440_209107662769058_6292389531513745098_n.jpg?oh=77e4931df9b22787a79578934478528d&oe=576E030A",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfp1/v/t1.0-9/12646993_209107766102381_1007228368201632842_n.jpg?oh=cf6a0f266336148e6f2071dc6c61fe10&oe=5770ADD2",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/12552938_209107769435714_1773013879184540647_n.jpg?oh=6e2a5d78270056128adaf5d41ad904ad&oe=5752E96F",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xla1/t31.0-8/s960x960/12622390_209107786102379_3353611626407246963_o.jpg",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/12552651_209107816102376_2820106990922351744_n.jpg?oh=b113046db90537deaa9909fa3607b589&oe=576770BF",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlt1/v/t1.0-9/12565470_209107926102365_4636844146326780281_n.jpg?oh=7bcbf1931fd1e1e09f6812f5ed2515eb&oe=575703C5",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfl1/t31.0-8/s960x960/12622288_209107986102359_1505181288365067001_o.jpg",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/12540612_209108046102353_8306802223711451936_n.jpg?oh=1533d15c5847cfeb1bca163938114248&oe=5768133F",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/12573932_209108049435686_6800687228658199126_n.jpg?oh=4ce052f874b704fbbd8581f95db44983&oe=5727FE27",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/10408973_209108076102350_3169020037689085202_n.jpg?oh=85399d19e3dc5e6d48900f61b42f9a52&oe=576990D3",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/12573168_209108156102342_6051917389304421972_n.jpg?oh=4bb485ba620ccbae77d579372de4e5ec&oe=5756EF86",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/12540849_209108229435668_2137510750079330616_n.jpg?oh=e3071e44681ee1ee0ac9f03e39990c7a&oe=57597B46",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlp1/v/t1.0-9/12400982_209108249435666_5890686695206612379_n.jpg?oh=c37d8e361ead0ab1060901308cd48e2a&oe=57255E80",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/5430_209108809435610_497727268841407465_n.jpg?oh=88cb672d6f8f0a57c72a1f508ceb7957&oe=577045CE",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtf1/v/t1.0-9/12553103_209108869435604_826825801747633697_n.jpg?oh=c86f36cf3f1a8182bc094bb8c50311c6&oe=575FBE09",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xat1/v/t1.0-9/12644835_209108929435598_7900072310447995062_n.jpg?oh=0bc6fe251e35e90e1dc95b7d78efa0d9&oe=576792AB",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtp1/v/t1.0-9/12109280_10153275801327087_6525520260986341431_n.jpg?oh=d839b761d2e8c1466383b22cbb766e15&oe=576DA927",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtf1/v/t1.0-9/11998843_10153199209007087_2343970704633138036_n.jpg?oh=fdfdff09186cb89965b256268b187ca3&oe=576EBE42",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/12647132_209110092768815_2456536108274165491_n.jpg?oh=c719b99b1fdbcb2e630b81167d5e743a&oe=5768ADFB",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/12549087_209110099435481_1670742954931551249_n.jpg?oh=20228908c5c7dc650e343308a871b10c&oe=575C7AF0",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xft1/v/t1.0-9/12644745_209110106102147_3191743897673119617_n.jpg?oh=1f39edbcfdf716d346a6f9b702efd6c3&oe=5754FE6E",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtp1/v/t1.0-9/12540850_209110346102123_8896769554654406086_n.jpg?oh=5072b153cbe946a3bb65f36e629a747e&oe=5763B4C0",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfp1/v/t1.0-9/12552815_209110392768785_693635347892229619_n.jpg?oh=ff4e301f87eebb2c1c87386cdb0c669a&oe=5753D07A",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlp1/v/t1.0-9/12524023_209110396102118_3577694128272053672_n.jpg?oh=dac7ca78ec9d0017eb982c2be2870539&oe=575A3CC3",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlp1/v/t1.0-9/12572972_209110492768775_7313897139170380646_n.jpg?oh=01bb002b69756f4160a6e28692000040&oe=57284F68",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/12540668_209110509435440_4442306183840051498_n.jpg?oh=5c8f0ddee6976f6e29c88a56f4630158&oe=572A1DFB",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xta1/v/t1.0-9/12540860_209110566102101_259853711985840765_n.jpg?oh=6799d4f8601b70d91505984c65d60456&oe=575E4FCF",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/12592689_209110859435405_6803518256474204457_n.jpg?oh=6737f37f45d74e39da7f0174ae2cd81a&oe=5729F1D9",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpt1/v/t1.0-9/12494954_209110899435401_3170122827131887116_n.jpg?oh=a1b8351310cb1b630ae0159bffd7c30a&oe=5762EF02",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtf1/v/t1.0-9/12644943_209110952768729_430993313348351470_n.jpg?oh=da173eb9e3c2ad3696ab1d4961e272fd&oe=5757CA9D",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfp1/v/t1.0-9/12540592_209111052768719_2744619839058805418_n.jpg?oh=e9662eb7475f18f2fb44da3e92f75499&oe=5758027B",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtf1/v/t1.0-9/12541148_209111142768710_3933701408073620361_n.jpg?oh=b8cf4ba996fa8d31b1810a0fc1acad68&oe=576D55A2",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfl1/v/t1.0-9/6874_209111209435370_2297561637172490516_n.jpg?oh=7911c028d55a5fa30b5a96bd8b0ca4dd&oe=575AAF4D",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/12573729_209111216102036_3603925758433025256_n.jpg?oh=7b7edf37a2aa8b6a91fa4f2e0a58eef7&oe=576AED33",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xal1/v/t1.0-9/944048_209111319435359_6294313604719159577_n.jpg?oh=6662ffbb7c74b9d0214009719cfe49a6&oe=57574EEA",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfa1/t31.0-8/s960x960/11222162_209111402768684_7956898408024273182_o.jpg",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfl1/v/t1.0-9/12572975_209111459435345_5987153702347853123_n.jpg?oh=d15964816135da5f39685b3c3285b9bf&oe=575CCDFF",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpa1/v/t1.0-9/12540919_209111482768676_158868356397193202_n.jpg?oh=a571e6931b5155dd5a6b689167901c96&oe=5723AEF6",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xta1/v/t1.0-9/12548953_209111546102003_6549221971955448853_n.jpg?oh=7d5a0f4ff81338fa22854448377c2250&oe=57630DF0",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpt1/v/t1.0-9/12592669_209111606101997_2907477838210830158_n.jpg?oh=2760da9e4a532869e09f0db0753e82fd&oe=57570621",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/12631450_209111752768649_3247825785205419057_n.jpg?oh=6e2e6ddf1227bbf35efd0a35a916276e&oe=575ABFA0",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlf1/v/t1.0-9/12552734_209111759435315_719722646319489098_n.jpg?oh=faad68a73d9b2f54c3adc9a79cc75c01&oe=57549CA0",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/t31.0-8/s960x960/12622525_209107169435774_6353026305435335591_o.jpg",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/12548863_209109989435492_8431523963919239112_n.jpg?oh=597e5791a4dd56cf542267a657dfafed&oe=575D45B2",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/12321237_209109202768904_8026876076851849322_n.jpg?oh=e17c088a377a9e6eeb985900c8f3f0a1&oe=5765BB0E",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xlf1/v/t1.0-9/12565364_209109209435570_8293897109338136016_n.jpg?oh=289d41838542334ab6be4c495476e2a7&oe=5759696E",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpt1/t31.0-8/s960x960/12604847_209109372768887_985455392398103586_o.jpg",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpt1/t31.0-8/s960x960/12525414_209109369435554_1297544635762071299_o.jpg",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xat1/v/l/t1.0-9/12642624_209109379435553_301785513355014061_n.jpg?oh=3b5843a983f1d5023f2efca68988268e&oe=5759B5EB",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xta1/v/t1.0-9/12642809_209109482768876_4639560906814502086_n.jpg?oh=4d02a39a643f2fc18787b0bf55c4d086&oe=5756BE42",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/t1.0-9/12552509_209109539435537_7924696005157549062_n.jpg?oh=5c868e5c043d64cbaacda35f60efcf70&oe=5756243B",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtf1/v/t1.0-9/12548957_209109549435536_4875120602913993259_n.jpg?oh=3f4619c1577a7b35fc82445dc4f0fc00&oe=575E78B5",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtp1/v/t1.0-9/12540829_209109746102183_1373076771759454418_n.jpg?oh=de65fc24c3559b9cd74f641a9dc9387d&oe=5758A778",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/12642866_209109796102178_2178956154204738344_n.jpg?oh=b523024ad0d6a8a1ef77c388f55f6a5a&oe=5767B0B4",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/12540751_209109806102177_4590918962038652969_n.jpg?oh=8bea9a840ab357a0d617e580b968d53b&oe=57545635",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/12565601_209109879435503_7131284373141547538_n.jpg?oh=a4df8c709da22ece02cc7235bf68c2d1&oe=5764AA61",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/12642968_209109896102168_6130200459223682400_n.jpg?oh=e145584d55c3cdd938777ebb0f64c134&oe=576A7B63",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/l/t1.0-9/12512810_209109889435502_4627849881491738017_n.jpg?oh=c205bb068ca4d2915f2ec447f20f7936&oe=575E6E28",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpl1/v/l/t1.0-9/12573086_209109612768863_3859380919772923564_n.jpg?oh=44e04d6dbef3c5196daacf0bada37660&oe=5723FC20",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpa1/v/t1.0-9/940847_209109606102197_1371872255137018067_n.jpg?oh=29130b975dac7ad1923eb992edfe951d&oe=576FE739",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpa1/v/t1.0-9/12631515_209109552768869_5094198666737461801_n.jpg?oh=0d3037b35aae343aa188390f8a01fbb5&oe=5755DF5B",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xat1/v/t1.0-9/12644892_209108946102263_6024585700433407860_n.jpg?oh=316954923f77a184262e87ae3253bd45&oe=57276EEB",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpt1/v/t1.0-9/12553087_209108949435596_7154751309635067172_n.jpg?oh=28766b4024c0a4189c6cbe9ba7d049c3&oe=5760E2F9",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtp1/v/t1.0-9/12573938_209108969435594_375527226199107843_n.jpg?oh=40fcfea9806464951cf1316b6824df28&oe=575B71DE",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpa1/v/t1.0-9/12552707_209109109435580_8863183873326949915_n.jpg?oh=e49ccdc8981493dd9c95ffb239ea91b4&oe=57692D66",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xtl1/v/t1.0-9/12646951_209109146102243_5104010507096563489_n.jpg?oh=5c9426e1580d5052b02e47229f6f3bb2&oe=575733B7",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/74382_150205778464946_760516509_n.jpg?oh=42bf8e1c6d59f19b2f6f586c0057cbcb&oe=5723B664",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/424413_150211121797745_96685464_n.jpg?oh=77dc93dbbb85a028bbd156eef40e1cfc&oe=575A4B66",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/398071_150211058464418_969704705_n.jpg?oh=caa2f4d6736660de22dec5fda3c86331&oe=57288A32",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/68466_150209215131269_462361643_n.jpg?oh=36f9140dd3bbcacccc7a78798dc9e16e&oe=5768E18F",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/428127_150209171797940_296776883_n.jpg?oh=fad4fef450511f6eb6e3575e07a5f89e&oe=5763DF3D",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xfa1/v/t1.0-9/582270_150209131797944_18039104_n.jpg?oh=682e20f604c883ec92a5a13240380760&oe=576777E6",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/554279_150209111797946_1722240412_n.jpg?oh=90875686812ac5d67736918b96c8ee7a&oe=57530CA9",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/537383_150208131798044_1451280048_n.jpg?oh=4420e91866e4423c931fd353213992fb&oe=5768B862",
           "https://scontent-ord1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/734043_150206528464871_1550764956_n.jpg?oh=82a06d771e6b3bc10306b1c09b0765c9&oe=57568DD8"

   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        gridView = (GridView) findViewById(R.id.galleryGridView);
        gridviewAdapter = new GridviewAdapter(GalleryPage.this, items);

        gridView.setAdapter(gridviewAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                String imageFull = gridviewAdapter.getItem(position).toString();
                intent.setDataAndType(Uri.parse(imageFull),"image/*");
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
//        gridView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent();
//                String imageFull = gridviewAdapter.getItem(pos)
//            }
//        });
    }



//    public static ArrayList<String> getAllShownImagesPathActivity(Activity activity){
//        Uri uri;
//        Cursor cursor;
//        int column_index_data, column_index_folder_name;
//        ArrayList<String> listOfAllImages = new ArrayList<String>();
//        String absolutePathOfImage = null;
//        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//
//        String[] projection = {MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME};
//
//        cursor = activity.getContentResolver().query(uri, projection, null, null, MediaStore.Images.Media.DATE_ADDED);
//    }
}
