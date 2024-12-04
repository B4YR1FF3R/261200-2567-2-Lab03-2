public class Main {
    public static void main(String[] args) {
        // กำหนดปีไว้
        int currentYear = 2024;

        // คนไข้ที่ดี
        Patient GoodPatient = new Patient(1001, "John Doe", 1978, 175.5, 78.0, "0970495956", "A");
        GoodPatient.displayDetails(currentYear);

        // คนไข้เกรียน
        Patient BadAssPatient = new Patient(1002, "Joe Dohn", 1990, -160.0, -65.0, "0825659119", "B");
        BadAssPatient.displayDetails(currentYear);
    }
}

class Patient {
    // กำหนดตัวแปร
    private int id;
    private String name;
    private int birthYear;
    private double height;
    private double weight;
    private String bloodGroup;
    private String phoneNumber;

    // เงื่อนไขต่างๆ
    public Patient(int id, String name, int birthYear, double height, double weight, String phoneNumber, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.phoneNumber = phoneNumber;

        // เงื่อนไขอายุ
        if (birthYear <= 0 || birthYear > 2024) {
            System.out.println("Invalid birth year provided. Setting birth year to default (2000).");
            this.birthYear = 2000;
        } else {
            this.birthYear = birthYear;
        }

        // เงื่อนไขความสูง
        if (height <= 0) {
            System.out.println("Invalid height provided. Setting height to default (165 cm).");
            this.height = 165.0;
        } else {
            this.height = height;
        }

        // เงื่อนไขน้ำหนัก
        if (weight <= 0) {
            System.out.println("Invalid weight provided. Setting weight to default (60 kg).");
            this.weight = 60.0;
        } else {
            this.weight = weight;
        }
    }

    // รับค่าต่างๆ
    public int getId() {
        return id;
    }

    // รับชื่อ
    public String getName() {
        return name;
    }

    // รับปีเกิด
    public int getBirthYear() {
        return birthYear;
    }

    // รับส่วนสูง
    public double getHeight() {
        return height;
    }

    // รับหมู่เลือด
    public String getBloodGroup(){
        return bloodGroup;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    // รับน้ำหนัก
    public double getWeight() {
        return weight;
    }

    // รับค่าอายุ
    public int getAge(int currentYear) {
        if (currentYear <= birthYear) {
            System.out.println("Invalid current year provided. Unable to calculate age.");
            return 0;
        }
        return currentYear - birthYear;
    }

    // รับค่า BMI
    public double getBMI(){
        // ตรวจว่าใส่น้ำหนัก ใส่ส่วนสูงถูกไหม
        if (height <= 0 || weight <= 0) {
            return 0.0; // ถ้าไม่ให้ออกค่า 0 มา
        }
        // สูตรหา BMI: น้ำหนัก / (ความสูงหน่วยเมตร)^2
        double heightInMeters = height / 100;
        return weight / (heightInMeters * heightInMeters);
    }


    // แสดงค่า
    public void displayDetails(int currentYear) {
        System.out.println("Patient Name: " + name);
        System.out.println("Patient Age: " + getAge(currentYear));
        System.out.println("Patient Height (cm): " + height);
        System.out.println("Patient Weight (kg): " + weight);
        System.out.println("Patient PhoneNumber: " + phoneNumber);
        System.out.println("Patient BloodGroup: " + bloodGroup);
        System.out.println("Patient BMI: " + getBMI());
    }
}
