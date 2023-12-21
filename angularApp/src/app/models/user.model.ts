export class User {
    firstName !: String;
    lastName !: String;
    address !: String;
    emailId !: String;
    mobileNo !: String;
    jobRole !: String;
    password !: String;

    constructor(firstName: String, lastName: String, address: String, emailId: String, mobileNo: String, jobRole: String, password: String) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.jobRole = jobRole;
        this.password = password;
    }
}

