#Assignment
The module consists of an online platform designed to manage patients, caregivers and
medication. The system can be accessed by three types of users after a login process: doctor,
patient and caregiver. The doctor can perform CRUD operations on patient (defined by ID,
name, birth date, gender, address, medical record) and caregiver (defined by ID, name, birth
date, gender, address, list of patients taken care of) accounts and on the list of medication
(defined by ID, name, list of side effects, dosage) available in the system. Furthermore, the
doctor can create a medication plan for a patient, consisting of a list of medication and intake
intervals needed to be taken daily, and the period of the treatment. The patients can view their
accounts and their medication plans. The caregivers can view their associated patients and the
corresponding medication plans.

#Functional Requirements
- Users log in. Users are redirected to the page corresponding to their role.
- Doctor Role:
    - CRUD operations on patients
    - CRUD operations on caregivers
    - CRUD operations on medication
    - Create medication plan for a patient, consisting of a list of medication and intake
intervals needed to be taken daily, and the period of the treatment
- Caregiver Role
    - A caregiver can view on his/her page all the patients associated in a list or table.
- Patient Role
    - A patient can view in his/her page their accounts details and their medication
plans
- The users corresponding to one role will not be able to enter the pages corresponding to
other roles (e.g. by log-in and then copy-paste the admin URL to the browser)

#Implementation
- Java 1.8 with Java Spring Boot
- Angular
- MySQL Database


#Swagger
- Swagger link: http://localhost:8080/swagger-ui.html#/