# 🚖 Taxi Booking System

A **Java-based taxi booking system** that automatically assigns taxis to customers based on availability, proximity, and earnings optimization.

---

## ✨ Features

- 🚗 **Automatic Taxi Assignment:** Assigns the nearest available taxi to customers  
- 🕒 **Smart Scheduling:** Considers taxi availability and travel time  
- 💰 **Earnings Tracking:** Monitors taxi earnings and performance  
- 📜 **Booking History:** Maintains complete booking records for each taxi  
- 🚕 **Multiple Taxi Support:** Handles multiple taxis simultaneously  

---

## 🧩 Class Structure

| Class Name | Description |
|-------------|-------------|
| **Main** | Entry point of the application with sample test cases |
| **Customer** | Represents customer booking requests |
| **Taxi** | Manages taxi state and booking details |
| **Booking** | Stores individual booking information |
| **BookingSystem** | Core logic for taxi assignment and management |

---

## ⚙️ Project Setup

### 🧠 Prerequisites
- Java **JDK 8** or higher  
- Any Java IDE (**Eclipse**, **IntelliJ**, **VS Code**) or terminal with Java support

---

## 🚀 Installation & Execution

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/taxi-booking-system.git
cd taxi-booking-system

2️⃣ Compile All Java Files

javac *.java

3️⃣ Run the Application

java Main


⸻

📁 Example Output

Customer 1 booked Taxi 2 from A to D
Taxi 2 Total Earnings: ₹400
Customer 2 booked Taxi 1 from B to F
Taxi 1 Total Earnings: ₹600


⸻

🧱 System Architecture (PlantUML)

You can generate this diagram using PlantText or VS Code PlantUML extension.

@startuml
title Taxi Booking System Architecture

actor Customer
rectangle "BookingSystem" {
  component "Booking Manager" as BM
  component "Taxi Manager" as TM
  component "Earnings Tracker" as ET
}

Customer --> BM : Request Taxi
BM --> TM : Find Nearest Available Taxi
TM --> ET : Update Earnings
ET --> TM : Send Updated Data
TM --> BM : Confirm Taxi Assignment
BM --> Customer : Booking Confirmation

@enduml


⸻

🔄 Flowchart (PlantUML)

@startuml
start
:Customer enters pickup and drop locations;
:Check available taxis;
if (Taxi Available?) then (Yes)
  :Find nearest taxi;
  :Assign taxi;
  :Calculate fare and update earnings;
  :Display confirmation to customer;
else (No)
  :Display "No taxis available";
endif
stop
@enduml

