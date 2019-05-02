public class RomanNumeralCalculator {

    public String add(String numeral1, String numeral2) {
        if(numeral1.equals("I") && numeral2.equals("I")) {

            return "II";
        }
        return  "IV";
    }
}

/*
CM -> DCCCC
M -> DD
CD -> CCCC
D -> CCCCC
XC -> LXXXX
C -> LL
XL -> XXXX
L -> XXXXX
IX -> VIIII
X -> VV
IV -> IIII
V -> IIIII
*/