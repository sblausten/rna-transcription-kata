import java.util.Map;
import java.util.HashMap;

class RnaTranscription {

  private static final Map<Character, String> RNA_PAIRS = new HashMap<Character, String>() {{
    put('C', "G");
    put('G', "C");
    put('T', "A");
    put('A', "U");
  }};

  String transcribe(String dnaStrand) {
    return convertDnaToRna(dnaStrand);
  }

  private String convertDnaToRna(String dnaStrand) {
    String rnaStrand = "";
    char[] dnaElements = dnaStrand.toCharArray();
    for(char e : dnaElements) {
      rnaStrand += parseDnaElement(e);
    }
    return rnaStrand;
  }

  private String parseDnaElement(char dnaElement) {
    for (Map.Entry<Character, String> e : RNA_PAIRS.entrySet()){
      if(dnaElement == e.getKey()) { return e.getValue(); }
    }
    throw new IllegalArgumentException("Invalid input");
  }

}
