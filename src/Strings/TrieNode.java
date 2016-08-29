package Strings;

public class TrieNode {
    char c;
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        c = '0';
        children = new TrieNode[26];
        endOfWord = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbc = new StringBuilder();
        for(int i = 0; i < 26; ++i) {
            if(this.children[i]  != null) {
                sbc.append(this.children[i].c + " ");
            }
        }
        sb.append("[ " + this.c + ",{ " + sbc.toString() + "}, " + this.endOfWord + " ]");
        return sb.toString();
    }
}
