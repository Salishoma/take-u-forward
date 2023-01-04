package com.oma.strings;

public class Palindrome {
    public static String longestPalindrome(String str) {
        int left;
        int right;
        int i = 0;
        int max = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int maxIndex = str.length() - 1;
        while (i <= maxIndex) {
            left = i;
            right = i;
            while (right < maxIndex && str.charAt(right) == str.charAt(right + 1)) {
                right += 1;
            }
            i = right + 1;
            while (left > 0 && right < maxIndex && str.charAt(left - 1) == str.charAt(right + 1)) {
                left -= 1;
                right += 1;
            }
            max = maxRight - maxLeft;
            if (max < right - left) {
                maxLeft = left;
                maxRight = right;
            }
            if (max == maxIndex) {
                return str;
            }
        }
        return str.substring(maxLeft, maxRight + 1);
    }

    public static int minCharsforPalindrome(String str) {

//        10
//        jbpddkjbshbrfifbggeheamgkfpxkouokxpfkgmaeheggbfifrbhsbjkddpbjshpgtgohgfqfrfugqgu
//        hlfdgwfuoadiwpeakijbjxkauhxhxbphujhjlupitkucsofmmmmfoscuktipuljhjuhpbxhxhuakxjbjikaepwidaoufwgdflhm
//        lusvsgdhrrweuluggmcfxhppuqugycbdgaapdhvtgqjchjasyb
//        clmzjyqhwchtybbythcwhqyjzmlcayxxlsmursmmgqeynfgajupugptfipaolbcj
//        deuhhlsafkkpauuoldlpxvygglldmwgujjuhzozduvgratkiktargvudzozhujjugwmdllggyvxpldlouuapkkfaslhhuedrh
//        ckwkjfonaduojjohlwkqduftulcfvwxexikpkuaujqffypebac
//        eccrlwesuxapqwbqcsscqbwqpaxusewlrcceszoobldcggdbhupknxucxcdsrcgflmoa
//        gamhfnggutlllyhllxapmlphffhfkvbbtvtursykgiufffuigkysrutvtbbvkfhffhplmpaxllhyllltuggnfhmaggsiod
//        kcyhtjibjoybftjsczuaxkbjsejfhvdgkstsjsbkgahkpmasyjkcyhtjibjoybftjsczuaxkbjsejfhvdgks
//        gggupckkcpuggggluajaazgcskejwucyvaofagkpgffevxazseaerxbmt

        //Write your code here
        int count = 0;
        int left = 0;
        int right = str.length() - 1;
        String s = "";
        String front = "";
        while (left < right) {
            count += 1;
            s += str.charAt(right);
            if (str.charAt(left) != str.charAt(right)) {
                while (str.charAt(left) == str.charAt(right)) {
                    front += str.charAt(left);
                    left++;
                    right--;
                    if (left >= right) {
                        return str.length() - (left > right ? 2 * left : 2 * (left) + 1);
                    }
                    s += str.charAt(right);
                }
                if (!s.endsWith(front)) {
                    front = "";
                    left = 0;
                }

            } else {
                front += str.charAt(left);
                left += 1;
            }
            right -= 1;
        }
        return str.length() - (left > right ? 2 * left : 2 * (left) + 1);
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abcccb"));
        //        Test Cases
//        abcdefghijk
//        sdsdsyrryh
//        wertytrehj
//        mnoponmmklre
//        quiiuqqjggggg
//        gggggg
//        asdfghjklkjhgf
//        weeweeweerteeyuee
//        nnnvvnnnli
//        wererw

//        Expected Results
//        10
//        5
//        9
//        5
//        7
//        0
//        13
//        10
//        2
//        5
        System.out.println(minCharsforPalindrome("abcdefghijk"));
        System.out.println(minCharsforPalindrome("sdsdsyrryh"));
        System.out.println(minCharsforPalindrome("wertytrehj"));
        System.out.println(minCharsforPalindrome("mnoponmmklre"));
        System.out.println(minCharsforPalindrome("quiiuqqjggggg"));
        System.out.println(minCharsforPalindrome("gggggg"));
        System.out.println(minCharsforPalindrome("asdfghjklkjhgf"));
        System.out.println(minCharsforPalindrome("weeweeweerteeyuee"));
        System.out.println(minCharsforPalindrome("nnnvvnnnli"));
        System.out.println(minCharsforPalindrome("wererw"));
        System.out.println(minCharsforPalindrome("qqdkfjusiurgljgpjgnmmcgpbblmrkguhryirszbjfjjqabynjvobbsvyvcczskwwuoxjmqbe" +
                "skhsubxosuvznvfkarphzkfuiyyaenqkybugsiodrlvfxnloqkdjgaiyoovisrkeddaxygwqhqlsyqcmuhsyrpfvdioijzenzefignlupjavize" +
                "zdwhetnemhyrmkflatxhgdwsjrkszxqaywjumxjkecqhjjonfeeenknpiqbbzlaognhqnzvlinkgnyyujmkhwftqfnsriagiokchudmzjhsepkxku" +
                "exhxlvohufqpmyrnvnbcgebmreaosxwxlavffpvpoyajzutyylnjddxnmmpvfmfmtevwbpjogzfcpsbpnkxcrvttypvnwagydwllgqthijtroshhuy" +
                "yjslqvflimzhagqbavxtvqzsojsztyjwknfzruandfyjqyyhicyuruhaanviavgyfazomjkmusuxjhgdnvikqcnneevzqiepqxqxzblbvoefijnyo" +
                "eorrdkvzuptplkxlvbypbytaxehuxpsnognirecbcisagrpuxwawpqqisvhtbmathqgbeaeespyvapxygauiqznkywxxidkiubmgkuglvgvonqxocc" +
                "dbmbzerjntpvusmkbpxtawnpkyrdtngseuzlwsollzvfzugsxpqkqjjfxngndxleflcejulvsnbytihnvvprkewrzulveconjqmfmjnpcwrqnphxpj" +
                "tvkabpovmdkmujsbpfttkfjokrdzveipetoqxqxqlognuqsybmckhwnwcawysgdccbwsotcmwnhnvujwxualzzgyquuhpxiugzwmzwtpqutuautuvu" +
                "jxbbewifnuknzdzpxknsxtrwwacjenoneccfhptejtrirwncrxpwzzklmpxdgxhjsgwhlvaowsiejqwmtanklgfdbhygpqvlvmyvoiffzwplzulryj" +
                "rzgwvrmaecmznsbowavpbemqztcaamqelquhlhjserrogsgmbjaimvgkmywocuhflbrhqboctdtnlmwwvkyvjjjuptlkozgvaynwzhzbegnfmdsnhc" +
                "szkdazuhhozbcugkwzdsknkascuttgogirwpvnlymwkdhgumydvrrevztzpnndymopwyosrxceuficehpovoetchaocefuetjvvxwhrxveiznbyvzoo" +
                "ujwbyolzgplaojpqabmjmsicnixayeehkotoognwnvxdxldnbivxbhdzqjeocrqfmvomweqlopihspdrqjbmuxmojselacujnlqklfdfurqniivmtrx" +
                "aglmcmfzowxjadakkknmqmbmciubacckigtxabehwcqvhhukkhalhkubvbdfqlkhxyjyzaeobfrsaqrehgwzjxsnleehpslvqhureijyurxpqsdwvye" +
                "eoseoerxeitplkkjktfpbgtfpjybtxmauqfbndwtdeohkgxqlptqpeenxpxuobddbwdfyiekybxurdqofqxyhfoyinhowtlqofoujsgnhzmwupgffxk" +
                "fkxkyzisikcabulzqotmadlukfzynwuunyphrpsrerleefuadmspfcngsiojmrsxxpxkvrvjsikjdtpakmgigqsrysvkarmawwarmoozqyfrymowlct" +
                "tbfhtkinjjgihwtsqyyfcuclsbtioicoplknsmifwrovqieeyfhjwewuacnctpyfzdytjlmsgnfpxozzmgfshpslrmczcqfnrjpbnpujupebtizcohr" +
                "uopvhyzegyppmtchwilnveczpbwnwdnchqpphwbpvfcwfkkyzjixwtbcibwzbmfabjmckksgjjhdxuhhztgavmemvtxxsxmtbeelcgaxobstvpbncln" +
                "zhldoylvlutbzwoxiauhooaucelqwkvlbbrpmhaviarudxfvjktlucghqklrsvhggunlepwmhuravecuttmmwvowoctyvnyfybbrponuykucjuophbb" +
                "hywpaycyabpvtjzamxzuzdyrcmqvytnfiaqnimnncrgbmlydiqhnzakshrncgtqjnmtbtkraecuituteladpiqbhxycvxfahyozapfrslekfksfnfus" +
                "vfjjvopbpoioktslclkqcylwylhzjcljlsjpjuljpdwadqmjwkrmcaowfqhqlefdiqfjatsmjrnbqjugruarjqjgafifgtkljbzdvqsfmygxkxkllih" +
                "akmikyzjbwgeddsangvnmmfhhwykfwerbndkrrifsvfyamxzbjlyuaqtoejjrhayzjdzpnrspzxkacilojfgmpccvfeyxbiklmsexxdeqsrovmgehzd" +
                "dxfxgptwpkvbschspokggsapfajpwvbfbmlhwlbrcazxzjrpoamewhjpomgwhycborqmugykukfbdzidunmrugfmzfvrqffhxhqqlcqvjezqunpknvd" +
//                "vlmohwtsdcfguopghpwibpjfqhvuvzwltfbxesrhsuzbcpmrvevgmrcldgmqafrhiqovelhkecwxqzjhlbqrnrvjdvmmisyykpdxpdwxpzapijftbcyecxjtocpskjsgcoxjvovszresxffuvbwzpoqrtsmbcmtpmwuecfxfbiglbjuizxntwqzrdskwkbrwixxoslzstrdapnnnxqvjxssbugdplkpkyvrnniwsjcfbbgaadkfveaglbmprijymsnrbtsfmsvtdwvoypicchaawwelvzzykojsbxvqfeconolwqdvbdzjfpxxbvtkrmnkwntauvuqjemlzwafwykvsrqjmmsmymjgadtkeovwdicpksgsrvqwcstqnwyfxzutggpovthcirqbiaaeynbblmqfhobytbukkntjaxrgpnotiktjvrjtiyytlpbpliixfylqylheocsdaemxjiwdzfhqwnoiyzdyyqbeovqnlwcqtaemunogmxwapdmwzoibmooeonoklkodxcxqfysnafsshzrypaetemtjztdlhljhpgovrrmzgkneeyawzofvccqvpfvujipojhklrvdbtahspvzmrkqhwfachfszrtmklczdstesociyfxaxwfdtmojtxnmzediczmgmtxjgltozvqfzwwgcxongtrloyujjuhpsjcwlvjgsoaqotkpexiejjfiwixdaulonijrnpfgdhohsmzqraqczyshuwdmxdddixwyryxkoxfwuqjhyqgiumjickgoyryxticyanuefmgqrzdqfcbmoldplvbwrvtsaalrahnkpffxjjiwkoefccmieuysmqurprosxrskmhdmovxxedjerzkhezknbhrsfdcbrcuietprkrogivxnbbeifkgaapkwfsjfktsuiwxhkozwnlxwsbbljyovewuxnnusfmeettrvpzytncxhmjicajxyagwnriitdogbzdiztjzvojusjjhibykggyhddntsmisjiptwszatkdleuiobzonqoeigourkctuzvgaocaqyzdskgcfhpyfadfhaqoafuikwseejwnakqqworicqhbwnnkgwxizoymotvwoiymvwnemfdhjyqlnzcctuvxujycilyvfruqxeckutjkqdqdxupuqowybihkekasdstmhalykchcxjzbikypucbjtrpjxtkcmhxddodshenogleurdjkscpulsvigbqkiytggkdhafmpslfsfbpnqubclgfacmwrzwxatqxsguieanasuvmvucxhjmvnvxulzvjwcmxtpzqhxpdzchnduwnqogklsitdbwydezdktzmpbvzobumkdrwghrigthrcaveqtxmqsxgfibzsffbfvfoezdsozkkvpjankxgxktvotjlzqilrsrjjxswklujdimgzyuvopznfdxxqqbytnuuxtucmlzppzmihpsqwhnsrpaphtunbtyddfhnnkacethnuotrgubfzfkeebruguvszsxrsimsnlgvvccltooakniteytnaxcaopfwospyrylkvrqfoqnrjbxoiqrtpdyoghlminnouatjpafkwtgjadxvapvosklkoucyzfmehzttjokihyoyulasymwuicswhgtfgxgulrlzizfpsrpzytjwrkaazwrollcznaqvlozkvvenyjvqbpdjrinarvcpebbqfyxeaibbvnpugcapudujhspmdgnvryokofhdtntplegyxsovxandrydjvyqowoteuyrcnzabcptvyzmibbqbbdnzmnxtahhjmrtfakdizycusacvcnxuqsgzidrimbmdjclrfzkkhsgqcrjopyyjtlkrjnyshpgalvryftshrkbndkybcqvrkvkndurtgmfaehzytppddmklfczlgmcmphwqiqfzmnxebkpakvxdixgbtguukvbmxhwkbyatgwwcqzqzrlcbtbfpgitspopdsahsbtmxdtgqezgbpuqfnrpnxzmuazoyrhkopxxevbnfpnuwjnfdnmioziiwdkkkryvinvzipztotxltezivqmymwhaavfhsbejvccrzauszgzlismnyxditdksfsyreeeozjcnatqlkylgtwuvhieyiqqjnwtgtvcemztuhlnoosjautpptycyhcohrwvstdorcdoqwfjtrtnvkaxziqgardtchpjmgstlqplqkesohtcmyqwhcvviwoekpmgjjjywlgcmfgozmrvpyieawuneiktlauqvunsqxihtdwmnhpfyolfhqmogyyucujertbfjewtrzcfzarqbexdqiybemjylsxrdmonjtoubkgqpxjsibbjuvvfgxrwryuljszwpctznejtkifwxxiavhzvbptepmjipoznvnapmtghonorkmvftjvttqbpnpmbvysujxvekbtmbjayzpbcyvzdofaupfrlqevppgalruqvpnpoephlaljhykwljcmeosgjboifrqifwuvzsmkdxmghrnbppjwnchximybgupbcmstfbkdzxabdnufheidnnyzxfzylqwonkfitogdeflwreshpzxctdhnbsrknnwveuaboakywhgudtsboqxdfwoweyuisssoefrrchoxhinrduwvpqvtpyfnpvendbsbgwaumdybrdweyzceulbfyxpgljbabetamnkmdttvecefdoxoxfnsxqcfjcusottarqpyllcikhylbdfytivhxmgmlowkyskuyqcqqytdhsyzomiftothobgmlhnmstljrmpdlgydrtwoafhusyzvbqwuubbbviwptqkkbchsozitcaaikkrbrrlhpbesbtvxhrichqxbvsecllrbrhimocyyghbavlwgtxhqqwqtnuuernribovjcrqvymzgoyqnzghcoqslvdkzxyeeybpzuhpwcbqdrqolwojhzfuktfxgkkikqkubzwxiwhmsyzeafbslkpbdhwwtgfuchrgyfpyzttjvvzsbpxqvsjjzcechuzzqbcqdxkpkovohosqynonltgsvvfltdqbcwcjdokjedifytcfbvclqwqlwfbetxsyoxaivgltqrtsdsexlvqqvmfuuetjwruhzditfyftnjasowbmgsmbehrpuffkusyyptjywrmiobowxmddctzveeyyjxsgqwsjjrldxbqcgzdqwhvhdwmcbkiwmshnovtyxnmubfavnknekxjiaifmmxbqsrbzjeqydochvkwyevslzcdubkczdkaewwxmqgwqqbgqluodixkfvxrglksabkjgpjrfiqowljazuinaevyyatqmehmwbzgylhepujqsibpawmdtpfowdzkovailyjlfnumkkrcepvvrazddqzvybbquppznzjsbewywpadvhhvusguxweszdjtjlafgkebgftshfzhzmepvrrsrvrzditnwaisnohgxlejalzbivlxvmdubeuwkmnzzjmekloobvapghiazzmrliqindgtunpqmqxhpoghkyjjqivngzazxwtvmyqukwbbxgxarjwicltnbztragrkbuvbzeiaoxbhvtzxyjiiqbcqcigeehqeqlmvqwivebbojdsfbnnrcydwomidvpwmshdarrrvrvzxhpymxdjjevuushecpwvgvozfekkrwkvkxqsptevsurpkzsmcuxgxpzmnwxyzddhblnugnctqtzdonjsrangpjrhgdgyakpcocvhzhsgcoepgopgmjbgcqddlvxmrexpvisivjetwxvfotdrqhaslawigvpiarlewlbzdpjsoudplycsjsfcidwjbxpxyfsfvuvkzlyawlmsfxrvsppfktzeyakifexeipjuqzokazlmbhcoflrozjlangbsqjxkwpshkcydaoxlrmydwsyxkrbuwjolvlbjnyrrndvpiuvzoxnomcinlpykvgnbwkatcybmfoccwqwreozfhgivkizfchpabsxvkwlxidhtshlgrjhebsbbjtrbdluckfmojosvkfhvlphonlkjgqucywcbpslftwgedtykvudmroztdyjiytslmbkamwtukdlchhsotimjxnalneprglwabnwkkkbswkbecaxnpalpuskrkmqocyxkkwcchscwzarpefowrgdoazattswzflzlxubnbrhknpuemaqdqadtncrlmiadvkdeftepgzlxygkbkfgyfxhvqsaupbythwakooedaimxiwjnglngglgavmingglytnbdgygsofxjjkybaajhbzbjbyasrnumdnriwpxewylutgroycxcdjbtugturawfotlxobkmudreumfoqmvoattwfudljncgohwxdolsqimslcorpfdjvmgisnngfkemunqpltrrmgnsgsgcrromsyvollyoqxvzuqiipmnsgatvumzehanychtlsqhnysqknfkspxkhygsiqmpbsmfsrkrmihhyfvkcjkxvxypxcornesbmmlvmvjzfljxqrmttqhtjllpojsgtqyqynxrqegkeugktiftmymjipnbnlvyzjpjnhgixtgdzycdesjiovxucyrqdzglfuwquihxqkqrsdkticbgdyjycsqtishjepuemllkgkwztfymdynayjzobuwwnsusmvtolqnltqaqqiajcbjvkzviasfcptxhqkhhnbvbhwbbpiyrtqyzfgdlbzpsawryfqhiphgzizpqgpdpjjmzxpvtijtxtiudjjfjmmajekmmzpmodinhnsqvgqmknfugdfljdevrbemlwrzlzgbxybbygnsxiswsyywcrhuotagltdqdmavjxfavnildydulmdllskvgiqvbdjrsxsckpevdmutocqxjpmioctwuizsavxnjmxcycvikhvltxtfktkpswuzfwjkaibsrndxqawobccwysyopqsyedchqvaydczexjyzmukractacablyuqzapzlwielobpokpmndrrfxuctgnugirgvgvzbfxjavssrhohgklltjsnxttgqntmrbmizmcjqfqkbxxtokleulbqemljpmwyfxuozbuazjhcknyqzkcqkxruxfmhfsgndbwwchecxyshryrqlxsgpvxlznyurqhbyunfsaeiflifmwnezqexiomgaisqrxzbotffpxjahpvqhedutpkttnczskxxmilrzrxdizygvhccgrfwxvrzaeqpuqlzsagsqzqbgafysdcziawoemgpvkbagplnlpzeteahdbdkmsjkemdoyubtdjgxybwceeevgdfvnspmesajicsgawdjfvfsreumnobiomwnhmxmqxdgghkosvjfnawsphfkughhdmkbptkniiphsxqpafloftojiaaovvtjewngdkjshonwzjmlturixagwdsuitqbdlragfqchndtdbasetjdkpmgfftcipqodgcywkkixnheksjnmrkklkxhfkbxwbzdwoymhfjhqhtxltxajzuodfqihazbfziuxxmodkgmwtnmmvnavbmxcsytalgqfppwzaseyjumxssvgamimgtxixgpbmsnjyhidtfawifjkskefcvcweixjzpfktttqjuwfgtgleyoxbhzayxwfryjmnwryokoiwhnmodaussjzldywyoncoufcyokxanbzhzyatfnhsazxzqpxuvofusjnghckznlxcenbrfgrurbtivexkjvlepmcjygrkzwgitqxfhsqwijbcthjhzhfubthppnvjepxbmauvotxmokftqphoulwewfmqslzqtbftckgxapajlxjdvjkhrxtuzataillmtomrvxditdroyqdvagkunogyhqszapqxpohfsnpuhyjbhuhgdmqhsjqxogkuimwgducsmccqtxqsymcwveyxvouhazzymvuvmzfozkjuugzimwexvwauilsuisuhpnimzwanqoukzxzjmklbpjqojrfocnidzirqnykmtibxtgglirdzgodwjndutkddlmmtvfhvxwmbursvqeuzahvfzqqoadrfkfebyxofmabkwaftzuexfdhldjvwsysdnpwvjtlgvprfodzotidmsoootikpcbaqhqcxxylutdfxkaucnstdapkxixuarbzmtvfrewqgjcpqrzmxeelekrvswdrfedpvolpmremaqsqastmgbhnvdmvnqragpqpyojpaefjbjecjwpchnytgzxskbplszsnxkvpsjhrzjbdlqguurtzfoxkimygpvcjlllemzvdwwolldiuagrpyvavimdxhyohocehgfmxvjxcayaejwztpmqogmwshhhfcmzkdhqsozscwhecpqxbmoargnykplspyuvmhkrkzxwtvvaofgeihwwcsdcuvlzzexhhhosyqaaskhoiojqkefavptcsuqhkuutanuukgrsdjapbsluiqeisprsvsnsijdvbjwsbyvhakftbdedycjztcvdfxoxaepodcfvxaisdajyxlkdpotdqpgcesqhrzqhjqsztsdxaxtfyqsbrysjslzusaacbwmiatgwhweptbzjoksavtbepaealbjnidotbwmlqvqbmxaellyyhvgvmcxqyfsvpspzezkjiafzgsqnqgqasecuswvcbouelkdsoajwkbcksfzczgrnqtyljcmrhpcpkqhgtuotlmmzyruodospimkgtuxefkwnrmrdzukfstjufbkyqmuheflnmwtvnxpiyogkrslaqfyvlgrobqqjcpnwevvfbrqwlkmesebnfyrfwhhdevcyuutouuovlgqoulgelumsucx" +
                "hkhpavmgdsprocnnzlzsftmfwpqksfggonmtqksdsfamnsypojqpygdskovqeeebjkwwzsahdyjvrizevnbexjsupqaiwtvbmlvknjttppvrceld" +
                "kmxqpzjzgwnhfgpmjletpciwgdyllgcioeeynivinkelytyqvlwdkvmdeukpbiyvflrcnpolpykevktqzlpogpwrzcggpsyvuvsdmbuyzgrjrxs" +
                "yhddlkwuuuhrymuxfucneescmnonffkmjgtapvichvdaqidbhzsxiqehcuqpkhwbmbhnnlaoozmeqprszqtkepkvfpiieshnomyuvznfyltkzip" +
                "nudqgxbniiozpkoztgtofsafbhuqxkqgukvhugevbzgjgkcwbpbrtxghgyowglvgzabtffzjgivujdtekkhstthjjojmoemhwlfrbdzbjeagkql" +
                "lccqvrjqxtonaryoqkaaxqxnfktqbxahnfhrbzhmletewfrhlqaxtaimraerlomnfemynaaatmbaeesrrcmwithwrmosirvkpjkjlwcnzoxjozcr" +
                "uolkvalprhvtwcstvayxwpytlgslvfayzuvgsglcfcrlxvtevjjdsnwkhgjylmfdqbruufaoaszbqfhgbdyiqxhjtwjvfoipfjhxbdiueaf"));
    }
}
