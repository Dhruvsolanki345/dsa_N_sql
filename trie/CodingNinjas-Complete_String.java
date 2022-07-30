// https://www.codingninjas.com/codestudio/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0
class Node {
    Node[] links;
    boolean flag;
    
    Node() {
        links = new Node[26];
        flag = false;
    }
    
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    Node get(char ch) {
        return links[ch - 'a'];
    }
    
    void put(char ch) {
        links[ch - 'a'] = new Node();
    }
    
    void markEnd() {
        flag = true;
    }
    
    boolean isEnd() {
        return flag;
    }
}

class Solution {

  public static String completeString(int n, String[] a) {
      Node root = new Node();
      
      for(int i = 0; i < a.length; i++) {
          String str = a[i];
          Node curr = root;
          
          for(int j = 0; j < str.length(); j++) {
              if(!curr.containsKey(str.charAt(j))) {
                  curr.put(str.charAt(j));
              }
              
              curr = curr.get(str.charAt(j));
          }
          curr.markEnd();
      }
      
      String maxStr = "";
      
      for(int i = 0; i < a.length; i++) {
          String str = a[i];
          Node curr = root;
          boolean flag = false;
          
          for(int j = 0; j < str.length(); j++) {
              curr = curr.get(str.charAt(j));
              
              if(!curr.isEnd()) {
                  flag = true;
                  break;
              }
          }
          
          if(flag) continue;
          
          if(maxStr.length() < str.length()) maxStr = str;
          else if(maxStr.length() == str.length() && str.compareTo(maxStr) < 0) maxStr = str;
      }
      
      return maxStr == "" ? "None" : maxStr;
  }
}
