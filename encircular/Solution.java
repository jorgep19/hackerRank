public class Solution {
	public static void main(String[] args) {
		String[] commands = new String[] { "G", "L", "GRGL" };
		String[] outputs = doesCircleExist(commands);

		for(int i = 0; i < commands.length; ++i) {
			System.out.println(outputs[i]);
		}
	}

	private static String[] doesCircleExist(String[] commands) {
		String[] outputs = new String[commands.length];
		boolean isGPresent = false;
		int currentAngle;
		String current;

		for(int i = 0; i < commands.length; ++i) {
			currentAngle = 0;
			current = commands[i];

			for(int j = 0; j < current.length(); ++j) {
				switch (current.charAt(j)) {
					case 'G' :
						isGPresent = true;
					break;
					case 'L':
						currentAngle += 90;
					break;
					case 'R':
						currentAngle -= 90;
					break;
				}
			}

			outputs[i] = (currentAngle % 360) == 0 && isGPresent ? "NO" : "YES";
		}

		return outputs;
    }
}