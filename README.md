# HealGo: The Health Management System

**HealGo** is a console-based **Health Management System** designed to help healthcare providers efficiently manage patient records, doctor schedules, prescriptions, appointments, and payments. It aims to improve operational efficiency by automating administrative tasks and reducing manual effort in managing healthcare data.

---

## Features

### **Core Features:**

1. **Patient Management:**
   - Add, update, and view patient details, including medical history.
   - View patient prescriptions and payment history.

2. **Doctor Management:**
   - Add and update doctor profiles, including specialties and contact information.

3. **Appointment Management:**
   - Schedule, update, or cancel appointments.
   - View scheduled appointments for a particular doctor or patient.

4. **Prescription Management:**
   - Doctors can prescribe medications and record dosages and instructions for each patient.
   - Prescriptions are linked to patients and doctors.

5. **Payment Management:**
   - Track payments made by patients for medical services.
   - Link payments to both the patient and doctor.
   - Automatically update payment status to "Completed" once processed.

6. **Data Persistence:**
   - Data (patients, doctors, appointments, prescriptions, payments) is stored in **CSV files**, ensuring persistence even after program restarts.

---

## Technologies Used

- **Programming Language:** Java
- **Data Storage:** CSV File handling (using `BufferedReader` and `BufferedWriter`)
- **User Interface:** Console-based interface with colored output (using ANSI escape codes)
- **Design Pattern:** Object-Oriented Programming (OOP), Model-View-Controller (MVC)

---



