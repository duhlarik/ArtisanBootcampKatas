public class RomanNumeralCalculator {

    public String add(String numeral1, String numeral2) {
        String result;

        numeral1 = numeral1.replace("IV", "IIII");
        numeral2 = numeral2.replace("IV", "IIII");
        result = numeral1 + numeral2;

        result = result
                .replace("IIIII", "V")
                .replace("IIII", "IV");

        return result;
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