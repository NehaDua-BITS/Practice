package dsa.microsoft;

import java.util.Arrays;

public class ConflictingAppointments {

    public static void main(String[] args) {
        int[][] appointments = {
                {4, 5},
                {2, 3},
                {3, 6},
                {5, 7},
                {7, 8}
        };

//        boolean isConflicting = new ConflictingAppointments().doesConflict(appointments);
//        System.out.println("Appointments conflicts = " + isConflicting);

        new ConflictingAppointments().getAllConflictingAppointments(appointments);
    }

    private boolean doesConflict(int[][] appointments) {

        Arrays.sort(appointments, (o1, o2) -> o1[0] - o2[0]);

        int n = appointments.length;
        for (int i = 1; i < n; i++) {
            if (appointments[i][0] < appointments[i-1][1]) { //not checking equal because it can be back to back appointments
                return true;
            }
        }
        return false;
    }

    private void getAllConflictingAppointments(int[][] appointments) {
        Arrays.sort(appointments, (o1, o2) -> o1[0] - o2[0]);

        int n = appointments.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (appointments[j][0] < appointments[i][1]) {
                    System.out.println(Arrays.toString(appointments[i]) + " & " + Arrays.toString(appointments[j]));
                }
            }
        }
    }
}
