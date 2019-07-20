package cmesapp.cmes_app;

/**
 * Created by ASUS on 3/8/2018.
 */

public class MyList {


    public static String science_no[] = null;
    public static String english_no[] = null;
    public static String filipino_no[] = null;


    public MyList() {

        science_no = new String[24];
        for (int i = 0; i < science_no.length; i++)
            science_no[i] = i + "";

        english_no = new String[38];
        for (int i = 0; i < science_no.length; i++)
            english_no[i] = i + "";

        filipino_no = new String[37];
        for (int i = 0; i < filipino_no.length; i++)
            filipino_no[i] = i + "";
    }

    //TODO---------begin Science


    public Integer science_seasons_question[] = {
            R.drawable.autumn,
            R.drawable.spring,
            R.drawable.summer,
            R.drawable.winter
    };

    public String science_seasons_choices[][] = {
            {"autumn","summer","winter","spring"},
            {"spring","summer","autumn","winter"},
            {"summer","spring","autumn","winter"},
            {"winter","autumn","spring","summer"}
    };

    public Integer science_partsofaplant_question[] = {
            R.drawable.roots,
            R.drawable.stem,
            R.drawable.leaves,
            R.drawable.flower,
            R.drawable.fruits,
            R.drawable.seeds
    };

    public String science_partsofaplant_choices[][] = {
            {"roots","stem","leaves","flower"},
            {"stem","leaves","flower","fruit"},
            {"leaves","flower","fruit","seeds"},
            {"flower","fruit","seeds","roots"},
            {"fruit","seeds","roots","stem"},
            {"seeds","roots","stem","leaves"}
    };

    public Integer science_thesolarsystem_question[] = {
            R.drawable.mercury,
            R.drawable.venus,
            R.drawable.earth,
            R.drawable.mars,
            R.drawable.jupiter,
            R.drawable.saturn,
            R.drawable.uranus,
            R.drawable.neptune,
            R.drawable.pluto,
    };

    public String science_thesolarsystem_choices[][] = {
            {"mercury","venus","earth","mars"},
            {"venus","earth","mars","jupiter"},
            {"earth","mars","jupiter","saturn"},
            {"mars","jupiter","saturn","uranus"},
            {"jupiter","saturn","uranus","neptune"},
            {"saturn","uranus","neptune","pluto"},
            {"uranus","neptune","pluto","mercury"},
            {"neptune","pluto","mercury","venus"},
            {"pluto","mercury","venus","earth"}
    };

    public Integer science_typesofweather_question[] = {
            R.drawable.sunny,
            R.drawable.windy,
            R.drawable.rainy,
            R.drawable.stormy
    };

    public String science_typesofweather_choices[][] = {
            {"sunny","windy","rainy","stormy"},
            {"windy","rainy","stormy","sunny"},
            {"rainy","stormy","sunny","windy"},
            {"stormy","sunny","windy","rainy"}
    };



    //TODO----------------end Science

    //TODO ------- begin English


    public Integer english_animalfarm_question[] = {
            R.drawable.rooster,
            R.drawable.hen,
            R.drawable.chick,
            R.drawable.pig,
            R.drawable.sheep,
            R.drawable.lamb,
            R.drawable.horse,
            R.drawable.donkey,
            R.drawable.duck,
            R.drawable.goat,
            R.drawable.calf
    };

    public String english_animalfarm_choices[][] = {
            {"rooster","hen","chick","pig"},
            {"hen","chick","pig","sheep"},
            {"chick","pig","sheep","lamb"},
            {"pig","sheep","lamb","horse"},
            {"sheep","lamb","horse","donkey"},
            {"lamb","horse","donkey","duck"},
            {"horse","donkey","duck","goat"},
            {"donkey","duck","goat","calf"},
            {"duck","goat","calf","rooster"},
            {"goat","calf","rooster","hen"},
            {"calf","rooster","hen","chick"}
    };

    public Integer english_insects_question[] = {
            R.drawable.ant,
            R.drawable.bee,
            R.drawable.butterfly,
            R.drawable.ladybug,
            R.drawable.grasshopper,
            R.drawable.mosquito,
            R.drawable.housefly,
            R.drawable.moth,
            R.drawable.cricket,
            R.drawable.horned_beetle
    };

    public String english_insects_choices[][] = {
            {"ant","bee","butterfly","ladybug"},
            {"bee","butterfly","ladybug","grasshopper"},
            {"butterfly","ladybug","grasshopper","mosquito"},
            {"ladybug","grasshopper","mosquito","housefly"},
            {"grasshopper","mosquito","housefly","moth"},
            {"mosquito","housefly","moth","cricket"},
            {"housefly","moth","cricket","horned beetle"},
            {"moth","cricket","horned beetle","ant"},
            {"cricket","horned beetle","ant","bee"},
            {"horned beetle","ant ","bee","butterfly"}
    };

    public Integer english_partsofthebody_question[] = {
            R.drawable.head,
            R.drawable.eyes,
            R.drawable.nose,
            R.drawable.mouth,
            R.drawable.tongue,
            R.drawable.ears,
            R.drawable.arm,
            R.drawable.hand,
            R.drawable.shoulder,
            R.drawable.vended_knee,
            R.drawable.foot
    };

    public String english_partsofthebody_choices[][] = {
            {"head","eyes","nose","mouth"},
            {"eyes","nose","mouth","tongue"},
            {"nose","mouth","tongue","ears"},
            {"mouth","tongue","ears","arm"},
            {"tongue","ears","arm","hand"},
            {"ears","arm","hand","shoulder"},
            {"arm","hand","shoulder","knee"},
            {"hand","shoulder","knee","foot"},
            {"shoulder","knee","foot","head"},
            {"knee","foot","head","eyes"},
            {"foot","head","eyes","nose"}
    };

    public Integer english_shape_question[] = {
            R.drawable.traingle,
            R.drawable.circle,
            R.drawable.square,
            R.drawable.rectangle,
            R.drawable.heart,
            R.drawable.diamond,
            R.drawable.star,
            R.drawable.oval,
            R.drawable.octagon
    };

    public String english_shape_choices[][] = {
            {"triangle","circle","square","rectangle"},
            {"circle","square","rectangle","heart"},
            {"square","rectangle","heart","diamond"},
            {"rectangle","heart","diamond","star"},
            {"heart","diamond","star","oval"},
            {"diamond","star","oval","octagon"},
            {"star","oval","octagon","triangle"},
            {"oval","octagon","triangle","circle"},
            {"octagon","triangle","circle","square"}
    };

    public Integer english_number_question[] = {
            R.drawable.n0,
            R.drawable.n1,
            R.drawable.n2,
            R.drawable.n3,
            R.drawable.n4,
            R.drawable.n5,
            R.drawable.n6,
            R.drawable.n7,
            R.drawable.n8,
            R.drawable.n9
    };

    public String english_number_choices[][] = {
            {"zero","one","two","three"},
            {"one","two","three","four"},
            {"two","three","four","five"},
            {"three","four","five","six"},
            {"four","five","six","seven"},
            {"five","six","seven","eight"},
            {"siz","seven","eight","nine"},
            {"seven","eight","nine","zero"},
            {"eight","nine","zero","one"},
            {"nine","zero","one","two"}
    };

    public Integer english_alphabet_question[] = {
            R.drawable.aaa,
            R.drawable.bbb,
            R.drawable.ccc,
            R.drawable.ddd,
            R.drawable.eee,
            R.drawable.fff,
            R.drawable.ggg,
            R.drawable.hhh,
            R.drawable.iii,
            R.drawable.jjj,
            R.drawable.kkk,
            R.drawable.lll,
            R.drawable.mmm,
            R.drawable.nnn,
            R.drawable.ooo,
            R.drawable.ppp,
            R.drawable.qqq,
            R.drawable.rrr,
            R.drawable.sss,
            R.drawable.ttt,
            R.drawable.uuu,
            R.drawable.vvv,
            R.drawable.www,
            R.drawable.xxx,
            R.drawable.yyy,
            R.drawable.zzz
    };

    public String english_alphabet_choices[][] = {
            {"Aa","Bb","Cc","Dd"},
            {"Bb","Cc","Dd","Ee"},
            {"Cc","Dd","Ee","Ff"},
            {"Dd","Ee","Ff","Gg"},
            {"Ee","Ff","Gg","Hh"},
            {"Ff","Gg","Hh","Ii"},
            {"Gg","Hh","Ii","Jj"},
            {"Hh","Ii","Jj","Kk"},
            {"Ii","Jj","Kk","Ll"},
            {"Jj","Kk","Ll","Mm"},
            {"Kk","Ll","Mm","Nn"},
            {"Ll","Mm","Nn","Oo"},
            {"Mm","Nn","Oo","Pp"},
            {"Nn","Oo","Pp","Qq"},
            {"Oo","Pp","Qq","Rr"},
            {"Pp","Qq","Rr","Ss"},
            {"Qq","Rr","Ss","Tt"},
            {"Rr","Ss","Tt","Uu"},
            {"Ss","Tt","Uu","Vv"},
            {"Tt","Uu","Vv","Ww"},
            {"Uu","Vv","Ww","Xx"},
            {"Vv","Ww","Xx","Yy"},
            {"Ww","Xx","Yy","Zz"},
            {"Xx","Yy","Zz","Aa"},
            {"Yy","Zz","Aa","Bb"},
            {"Zz","Aa","Bb","Cc"}
    };

    //TODO end english

    //TODO ----- begin Filipino


    public Integer filipino_animalfarm_question[] = {
            R.drawable.rooster,
            R.drawable.hen,
            R.drawable.chick,
            R.drawable.pig,
            R.drawable.sheep,
            R.drawable.lamb,
            R.drawable.horse,
            R.drawable.donkey,
            R.drawable.duck,
            R.drawable.goat,
            R.drawable.calf
    };

    public String filipino_animalfarm_choices[][] = {
            {"tandang","inahin","sisiw","baboy"},
            {"inahin","sisiw","baboy","tupa"},
            {"sisiw","baboy","tupa","kornero"},
            {"baboy","tupa","kornero","kabayo"},
            {"tupa","kornero","kabayo","asno"},
            {"kornero","kabayo","asno","bibe"},
            {"kabayo","asno","bibe","kambing"},
            {"asno","bibe","kambing","guya"},
            {"bibe","kambing","guya","tandang"},
            {"kambing","guya","tandang","inahin"},
            {"guya","tandang","inahin","sisiw"}
    };

    public Integer filipino_insects_question[] = {
            R.drawable.ant,
            R.drawable.bee,
            R.drawable.butterfly,
            R.drawable.ladybug,
            R.drawable.grasshopper,
            R.drawable.mosquito,
            R.drawable.housefly,
            R.drawable.cricket,
            R.drawable.horned_beetle,
            R.drawable.moth
    };

    public String filipino_insects_choices[][] = {
            {"langgam","bubuyog","paruparo","ladybug"},
            {"bubuyog","paruparo","ladybug","tipaklong"},
            {"paruparo","ladybug","tipaklong","lamok"},
            {"ladybug","tipaklong","lamok","langaw"},
            {"tipaklong","lamok","langaw","kamaksi"},
            {"lamok","langaw","kamaksi","uwang"},
            {"langaw","kamaksi","uwang","gamugamo"},
            {"kamaksi","uwang","gamugamo","langgam"},
            {"uwang","gamugamo","langgam","bubuyog"},
            {"gamugamo","langgam","bubuyog","paruparo"}
    };

    public Integer filipino_partsofthebody_question[] = {
            R.drawable.head,
            R.drawable.eyes,
            R.drawable.nose,
            R.drawable.mouth,
            R.drawable.tongue,
            R.drawable.ears,
            R.drawable.arm,
            R.drawable.hand,
            R.drawable.shoulder,
            R.drawable.vended_knee,
            R.drawable.foot
    };

    public String filipino_partsofthebody_choices[][] = {
            {"ulo","mata","ilong","bunganga"},
            {"mata","ilong","bunganga","dila"},
            {"ilong","bunganga","dila","tenga"},
            {"bunganga","dila","tenga","braso"},
            {"dila","tenga","braso","kamay"},
            {"tenga","braso","kamay","balikat"},
            {"braso","kamay","balikat","tuhod"},
            {"kamay","balikat","tuhod","paa"},
            {"balikat","tuhod","paa","ulo"},
            {"tuhod","paa","ulo","mata"},
            {"paa","ulo","mata","ilong"}
    };

    public Integer filipino_shape_question[] = {
            R.drawable.traingle,
            R.drawable.circle,
            R.drawable.square,
            R.drawable.rectangle,
            R.drawable.heart,
            R.drawable.diamond,
            R.drawable.star,
            R.drawable.oval,
            R.drawable.octagon
    };

    public String filipino_shape_choices[][] = {
            {"tatsulok","bilog","parisukat","parihaba"},
            {"bilog","parisukat","parihaba","puso"},
            {"parisukat","parihaba","puso","brilyante"},
            {"parihaba","puso","brilyante","bituin"},
            {"puso","brilyante","bituin","habilog"},
            {"brilyante","bituin","habilog","walonsulok"},
            {"bituin","habilog","walonsulok","tatsulok"},
            {"habilog","walonsulok","tatsulok","bilog"},
            {"walonsulok","tatsulok","bilog","parisukat"}
    };

    public Integer filipino_number_question[] = {
            R.drawable.n1,
            R.drawable.n2,
            R.drawable.n3,
            R.drawable.n4,
            R.drawable.n5,
            R.drawable.n6,
            R.drawable.n7,
            R.drawable.n8,
            R.drawable.n9
    };

    public String filipino_number_choices[][] = {
            {"isa","dalawa","tatlo","apat"},
            {"dalawa","tatlo","apat","lima"},
            {"tatlo","apat","lima","anim"},
            {"apat","lima","anim","pito"},
            {"lima","anim","pito","walo"},
            {"anim","pito","walo","siyam"},
            {"pito","walo","siyam","isa"},
            {"walo","siyam","isa","dalawa"},
            {"siyam","isa","dalawa","tatlo"}
    };

    public Integer filipino_alphabet_question[] = {
            R.drawable.aaa,
            R.drawable.bbb,
            R.drawable.kkk,
            R.drawable.ddd,
            R.drawable.eee,
            R.drawable.ggg,
            R.drawable.hhh,
            R.drawable.iii,
            R.drawable.lll,
            R.drawable.mmm,
            R.drawable.nnn,
            R.drawable.ooo,
            R.drawable.ppp,
            R.drawable.rrr,
            R.drawable.sss,
            R.drawable.ttt,
            R.drawable.uuu,
            R.drawable.www,
            R.drawable.yyy
    };

    public String filipino_alphabet_choices[][] = {
            {"Aa","Bb","Cc","Dd"},
            {"Bb","Cc","Dd","Ee"},
            {"Kk","Ll","Mm","Nn"},
            {"Dd","Ee","Gg","Hh"},
            {"Ee","Gg","Hh","Ii"},
            {"Gg","Hh","Ii","Ll"},
            {"Hh","Ii","Ll","Mm"},
            {"Ii","Ll","Mm","Nn"},
            {"Ll","Mm","Nn","Oo"},
            {"Mm","Nn","Oo","Pp"},
            {"Nn","Oo","Pp","Rr"},
            {"Oo","Pp","Rr","Ss"},
            {"Pp","Rr","Ss","Tt"},
            {"Rr","Ss","Tt","Uu"},
            {"Ss","Tt","Uu","Ww"},
            {"Tt","Uu","Ww","Yy"},
            {"Uu","Ww","Yy","Aa"},
            {"Ww","Yy","Aa","Bb"},
            {"Yy","Aa","Bb","Kk"}
    };


    //TODO ------ end Filipino




    public int science_question[] = {

            R.drawable.autumn,//autumn
            R.drawable.cloudy,
            R.drawable.earth,
            R.drawable.flower,
            R.drawable.fruits,
            R.drawable.jupiter,
            R.drawable.leaves,
            R.drawable.mars,
            R.drawable.mercury,
            R.drawable.neptune,
            R.drawable.pluto,
            R.drawable.rainy,
            R.drawable.roots,
            R.drawable.saturn,
            R.drawable.seeds,
            R.drawable.spring,
            R.drawable.stem,
            R.drawable.stormy,
            R.drawable.summer,
            R.drawable.sunny,
            R.drawable.uranus,
            R.drawable.venus,
            R.drawable.windy,
            R.drawable.winter

    };


    public String science_choices[][] = {

            {"autumn","summer","winter","spring"},
            {"cloudy","rainy","stormy","windy"},
            {"earth","mars","venus","pluto"},
            {"flower","fruits","stem","roots"},
            {"fruits","stem","leaves","roots"},
            {"jupiter","neptune","mercury","jupiter"},
            {"leaves","seeds","stem","fruits"},
            {"mars","earth","saturn","uranus"},
            {"mercury","earth","saturn","uranus"},
            {"neptune","jupiter","earth","pluto"},
            {"pluto","neptune","mars","uranus"},
            {"rainy","windy","cloudy","sunny"},
            {"roots","stem","leaves","fruits"},
            {"saturn","jupiter","neptune","uranus"},
            {"seeds","fruits","roots","stem"},
            {"spring","summer","autumn","winter"},
            {"stem","roots","leaves","seeds"},
            {"stormy","windy","rainy","cloudy"},
            {"summer","spring","autumn","winter"},
            {"sunny","summer","windy","cloudy"},
            {"uranus","jupiter","earth","mercury"},
            {"venus","pluto","neptune","uranus"},
            {"windy","cloudy","stormy","rainy"},
            {"winter","autumn","spring","summer"}

    };


    public int getScience_question_length() {
        return science_question.length;
    }

    public int english_question[] = {

            R.drawable.ant
            ,R.drawable.bee
            ,R.drawable.butterfly
            ,R.drawable.calf
            ,R.drawable.chick
            ,R.drawable.circle
            ,R.drawable.cow
            ,R.drawable.diamond
            ,R.drawable.donkey
            ,R.drawable.duck
            ,R.drawable.goat
            ,R.drawable.grasshopper
            ,R.drawable.heart
            ,R.drawable.hen
            ,R.drawable.horse
            ,R.drawable.ladybug
            ,R.drawable.lamb
            ,R.drawable.mosquito

            ,R.drawable.n0
            ,R.drawable.n1
            ,R.drawable.n2
            ,R.drawable.n3
            ,R.drawable.n4
            ,R.drawable.n5
            ,R.drawable.n6
            ,R.drawable.n7
            ,R.drawable.n8
            ,R.drawable.n9

            ,R.drawable.octagon
            ,R.drawable.oval
            ,R.drawable.pig
            ,R.drawable.rectangle
            ,R.drawable.rooster
            ,R.drawable.sheep
            ,R.drawable.square
            ,R.drawable.star
            ,R.drawable.traingle
            ,R.drawable.worm
    };

    public String english_choices[][] = {

            {"ant","calf","chick","bee"}
            ,{"bee","calf","chick","butterfly"}
            ,{"butterfly","lady bug","bee","mosquito"}
            ,{"calf","horse","pic","goat"}
            ,{"chick","hen","rooster","calf"}
            ,{"circle","square","diamond","triangle"}
            ,{"cow","calf","pic","donkey"}
            ,{"diamond","heart","star","circle"}
            ,{"donkey","horse","goat","cow"}
            ,{"duck","chick","hen","rooster"}
            ,{"goat","donkey","calf","pig"}
            ,{"grasshopper","ant","bee","butterfly"}
            ,{"heart","star","rectangle","oval"}
            ,{"hen","rooster","chick","bee"}
            ,{"horse","goat","pic","cow"}
            ,{"lady bug","bee","grasshopper","ant"}
            ,{"lamb","goat","donkey","cow"}
            ,{"mosquito","bee","ant","butterfly"}
            ,{"zero","one","two","three"}
            ,{"one","two","three","four"}
            ,{"two","three","four","five"}
            ,{"three","four","five","six"}
            ,{"four","five","seven","eight"}
            ,{"five","six","seven","eight"}
            ,{"six","seven","eight","nine"}
            ,{"seven","eight","nine","one"}
            ,{"eight","nine","one","two"}
            ,{"nine","three","four","five"}
            ,{"octagon","rectangle","circle","square"}
            ,{"oval","circle","star","square"}
            ,{"pig","horse","goat","cow"}
            ,{"rectangle","square","star","circle"}
            ,{"rooster","hen","chick","pig"}
            ,{"sheep","donkey","pig","horse"}
            ,{"square","star","diamond","rectangle"}
            ,{"star ","diamond","rectangle","oval"}
            ,{"triangle","rectangle","square","star"}
            ,{"worm","mosquito","grasshopper","bee"}

    };



    public int filipino_question[] = {

            R.drawable.ant
            ,R.drawable.bee
            ,R.drawable.butterfly
            ,R.drawable.calf
            ,R.drawable.chick
            ,R.drawable.circle
            ,R.drawable.cow
            ,R.drawable.diamond
            ,R.drawable.donkey
            ,R.drawable.duck
            ,R.drawable.goat
            ,R.drawable.grasshopper
            ,R.drawable.heart
            ,R.drawable.hen
            ,R.drawable.horse
            ,R.drawable.ladybug
            ,R.drawable.lamb
            ,R.drawable.mosquito

            ,R.drawable.n1
            ,R.drawable.n2
            ,R.drawable.n3
            ,R.drawable.n4
            ,R.drawable.n5
            ,R.drawable.n6
            ,R.drawable.n7
            ,R.drawable.n8
            ,R.drawable.n9

            ,R.drawable.octagon
            ,R.drawable.oval
            ,R.drawable.pig
            ,R.drawable.rectangle
            ,R.drawable.rooster
            ,R.drawable.sheep
            ,R.drawable.square
            ,R.drawable.star
            ,R.drawable.traingle
            ,R.drawable.worm
    };

    public String filipino_choices[][] = {

            {"langgam","guya","sisiw","bubuyog"}
            ,{"bubuyog","guya","sisiw","paru-paro"}
            ,{"paru-paro","lady bug","bubuyog","lamok"}
            ,{"guya","kabayo","baboy","kambing"}
            ,{"sisiw","inahin","tandang","guya"}
            ,{"bilog","parisukat","brilyante","tatsulok"}
            ,{"baka","guya","baboy","asno"}
            ,{"brilyante","puso","bituin","bilog"}
            ,{"asno","kabayo","kambing","baka"}
            ,{"itik","sisiw","inahin","tandang"}
            ,{"kambing","asno","guya","baboy"}
            ,{"tipaklong","langgam","bubuyog","paru-paro"}
            ,{"puso","bituin","parhihaba","habilog"}
            ,{"inahin","tandang","sisiw","bubuyog"}
            ,{"kabayo","kambing","baboy","baka"}
            ,{"lady bug","bubuyog","tipaklong","langgam"}
            ,{"kordero","kambing","asno","baka"}
            ,{"lamok","bubuyog","langgam","paru-paro"}
            ,{"isa","dalawa","tatlo","apat"}
            ,{"dalawa","tatlo","apat","lima"}
            ,{"tatlo","apat","lima","anim"}
            ,{"apat","lima","pito","walo"}
            ,{"lima","anim","pito","walo"}
            ,{"anim","pito","walo","siyam"}
            ,{"pito","walo","siyam","isa"}
            ,{"walo","siyam","isa","dalawa"}
            ,{"siyam","tatlo","apat","lima"}
            ,{"walonsulok","parhihaba","bilog","parisukat"}
            ,{"habilog","bilog","bituin","parisukat"}
            ,{"baboy","kabayo","kambing","baka"}
            ,{"parhihaba","parisukat","bituin","bilog"}
            ,{"tandang","inahin","sisiw","baboy"}
            ,{"tupa","asno","baboy","kabayo"}
            ,{"parisukat","bituin","brilyante","parhihaba"}
            ,{"bituin ","brilyante","parhihaba","habilog"}
            ,{"tatsulok","parhihaba","parisukat","bituin"}
            ,{"bulate","lamok","tipaklong","bubuyog"}


    };






    //TODO SCIENCE

    public static int science_image[] = {

            R.drawable.topic_season,
            R.drawable.topic_partsofplants,
            R.drawable.topic_solarsystem,
            R.drawable.topic_weather

    };

    public static String science_topics[] = {

            "FOUR SEASONS",
            "PARTS OF A PLANT",
            "THE SOLAR SYSTEM",
            "TYPES OF WEATHER"

    };
    public static String science_topics_web[] = {

            "file:///android_asset/web/science/FOUR SEASONS.htm",
            "file:///android_asset/web/science/PARTS OF A PLANT.htm",
            "file:///android_asset/web/science/THE SOLAR SYSTEM.htm",
            "file:///android_asset/web/science/TYPES OF WEATHER.htm"

    };

    public int getScienceLength(){
        return science_topics.length;
    }




    //TODO SCIENCE

    public static int english_image[] = {

            R.drawable.topic_farm_animals,
            R.drawable.topic_insects,
            R.drawable.topic_partsofthebody,
            R.drawable.topic_shapes,
            R.drawable.topic_numbers,
            R.drawable.aaa

    };

    public static String english_topics[] = {

            "ANIMAL FARM",
            "INSECTS",
            "PARTS OF THE BODY",
            "SHAPES",
            "NUMBERS",
            "ENGLISH ALPHABET"

    };
    public static String english_topics_web[] = {

            "file:///android_asset/web/english/FARM ANIMALS.htm",
            "file:///android_asset/web/english/Insects.htm",
            "file:///android_asset/web/english/PARTS OF THE BODY.htm",
            "file:///android_asset/web/english/SHAPES.htm",
            "file:///android_asset/web/english/LEARN NUMBERS.htm",
            "file:///android_asset/web/english/ENGLISH ALPHABET.htm"

    };

    public int getEnglishLength(){
        return english_topics.length;
    }




    //TODO SCIENCE

    public static int filipino_image[] = {

            R.drawable.topic_farm_animals,
            R.drawable.topic_insects,
            R.drawable.topic_partsofthebody,
            R.drawable.topic_shapes,
            R.drawable.topic_numbers,
            R.drawable.aaa

    };

    public static String filipino_topics[] = {
            "MGA HAYOP SA BUKID",
            "MGA INSEKTO",
            "MGA BAHAGI NG KATAWAN",
            "HUGIS",
            "NUMERO",
            "ALPABETONG FILIPINO"


    };
    public static String filipino_topics_web[] = {

            "file:///android_asset/web/filipino/MGA HAYOP SA BUKID.htm",
            "file:///android_asset/web/filipino/MGA INSEKTO.htm",
            "file:///android_asset/web/filipino/MGA BAHAGI NG KATAWAN.htm",
            "file:///android_asset/web/filipino/HUGIS.htm",
            "file:///android_asset/web/filipino/NUMERO.htm",
            "file:///android_asset/web/filipino/ALPABETONG FILIPINO.htm"

    };

    public int getFilipinoLength(){
        return filipino_topics.length;
    }

}
