class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        boolean goingDown = false;
        int n = s.length(), cRow = 0;
        for(int i = 0; i < n; i++) {
            sbs[cRow].append(s.charAt(i));
            if(cRow == 0 || cRow == numRows - 1) {
                goingDown = !goingDown;
            }
            cRow += goingDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            res.append(sbs[i].toString());
        }
        return res.toString();
    }
}
