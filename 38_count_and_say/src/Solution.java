
public class Solution {
	public String countAndSay(int n) {
		int i = 1;
		String res = "1";
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (i < n) {
			i++;
			char value = res.charAt(0);
			for (int j = 0; j < res.length(); j++) {
				if (value == res.charAt(j)) {
					count++;
					if (j == res.length()-1) {
						sb.append(count);
						sb.append(value);
						res = sb.toString();
						sb = new StringBuilder();
						System.out.println(res);
						count = 0;
						break;
					}
				} else {
					sb.append(count);
					sb.append(value);
					if (j == res.length()-1) {
						sb.append(1);
						sb.append(res.charAt(j));
						res = sb.toString();
						sb = new StringBuilder();
						System.out.println(res);
						count =0;
						break;
					}
					count = 1;
					value = res.charAt(j);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		obj.countAndSay(6);
	}
}
