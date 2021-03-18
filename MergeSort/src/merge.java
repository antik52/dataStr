import java.util.Arrays;

public class merge {
	
		public static void mergeSort(int[] source, int left, int right) {
        // ������� �����������, �.�. �������� ������� ������� ������
        int delimiter = left + ((right - left) / 2) + 1;
        // �������� ���������� ������ ������� ��� ���� ��������� (���� ������ �������(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }
        // ������ ��������� ������ � ������ ��������
        int[] buffer = new int[right - left + 1];
        // ������� �� ��������� ����� ������� ��� �� ������� ��������
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // �� ���������� delimeter ����� ��������� �� ������� �� ������ �����
            // ���� delimeter > right, ������ � ������ ����� �� �������� ������������� ���������
            if (delimiter > right || source[cursor] > source[delimiter]) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
}
}
