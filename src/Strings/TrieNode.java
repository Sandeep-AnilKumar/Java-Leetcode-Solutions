package Strings;

public class TrieNode {
    char c;
    TrieNode[] next;
    boolean endOfWord;

    public TrieNode() {
        c = '0';
        next = new TrieNode[26];
        endOfWord = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbc = new StringBuilder();
        for(int i = 0; i < 26; ++i) {
            if(this.next[i]  != null) {
                sbc.append(this.next[i].c + " ");
            }
        }
        sb.append("[ " + this.c + ",{ " + sbc.toString() + "}, " + this.endOfWord + " ]");
        return sb.toString();
    }
}
