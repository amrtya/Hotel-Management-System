export class User {
    custId !: String;
    firstName !: String;
    lastName !: String;
    address !: String;
    emailId !: String;
    mobileNo !: String;
    jobRole !: String;
    password !: String;

    constructor(firstName: String, lastName: String, emailId: String, mobileNo: String, jobRole: String, address?: String, password?: String) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.jobRole = jobRole;

        if(address) this.address = address;
        if(password) this.password = password;
    }
}

