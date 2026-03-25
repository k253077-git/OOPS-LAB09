package Innerclass;

abstract class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }

    // Must implement treatment
    abstract void getTreatment();
}
interface InsuranceService {
    default void serviceStatus() {
        System.out.println("Insurance Service");
    }
}

interface EmergencyService {
    default void serviceStatus() {
        System.out.println("Emergency Service");
    }
}
class SmartPatient extends Patient implements InsuranceService, EmergencyService {

    // Inner Class → MedicalHistory
    class MedicalHistory {
        void showHistory() {
            System.out.println("Medical History");
        }
    }
    MedicalHistory history;

    SmartPatient(String name) {
        super(name);
        history = new MedicalHistory();
    }

    @Override
    void getTreatment() {
        System.out.println("Getting treatment for patient: " + name);
    }

    @Override
    public void serviceStatus() {
        System.out.println("Patient Services");
        InsuranceService.super.serviceStatus();
        EmergencyService.super.serviceStatus();
    }

    void showMedicalHistory() {
        history.showHistory();
    }
}
public class Hospital {
    public static void main(String[] args) {

        SmartPatient patient = new SmartPatient("Ali");

        patient.getTreatment();
        patient.serviceStatus();
        patient.showMedicalHistory();
    }
}

