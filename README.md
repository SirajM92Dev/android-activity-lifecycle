# Android Activity Lifecycle Demonstration

This project demonstrates the complete Android Activity Lifecycle through practical implementation and visual tracking across two distinct activities (`MainActivity` and `SecondActivity`).

---

## 📌 Project Overview

An Android Activity passes through several states from the moment it is launched until it is destroyed. In this project, each lifecycle callback is overridden and triggers a distinct `Toast` notification, allowing users and reviewers to visually observe each transition in real time.

- **MainActivity**: Displays bottom-aligned Toast messages during state transitions and includes a clickable view to trigger navigation.
- **SecondActivity**: Uses center-aligned Toast messages to prevent visual overlap with MainActivity's messages.

---

## 🔄 Lifecycle Methods Demonstrated

Each activity overrides all 7 fundamental Android lifecycle callbacks:

| Callback | Invocation Point |
| :--- | :--- |
| `onCreate()` | Called when the activity is first created. Initializes UI components and view bindings. |
| `onStart()` | Called when the activity becomes visible to the user. |
| `onResume()` | Called when the activity starts interacting with the user (in foreground). |
| `onPause()` | Called when the system is about to resume another activity (partially obscured). |
| `onStop()` | Called when the activity is no longer visible to the user. |
| `onRestart()` | Called after the activity has been stopped, prior to starting again. |
| `onDestroy()` | Called before the activity is destroyed by the system or via `finish()`. |

---

## 🚀 Transition Sequence

1. **App Launch**:
   $$\text{onCreate()} \rightarrow \text{onStart()} \rightarrow \text{onResume()}$$
2. **Navigating to SecondActivity**:
   - `MainActivity: onPause()`
   - `SecondActivity: onCreate()` $\rightarrow$ `onStart()` $\rightarrow$ `onResume()`
   - `MainActivity: onStop()`
3. **Pressing Back to Return to MainActivity**:
   - `SecondActivity: onPause()`
   - `MainActivity: onRestart()` $\rightarrow$ `onStart()` $\rightarrow$ `onResume()`
   - `SecondActivity: onStop()` $\rightarrow$ `onDestroy()`
4. **Minimizing/Exiting the App**:
   $$\text{onPause()} \rightarrow \text{onStop()} \rightarrow \text{onDestroy()}$$

---

## 📁 Repository Structure

- `MainActivity.java` — Core launcher activity with lifecycle callbacks and Intent navigation.
- `SecondActivity.java` — Secondary activity demonstrating center-aligned toast logging.
- `activity_main.xml` — Layout containing clickable navigation UI for `MainActivity`.
- `activity_second.xml` — Layout for `SecondActivity`.
- `AndroidManifest.xml` — Manifest registering both activities and specifying the launcher activity.

---

## 🛠️ Requirements & Setup

- **Language**: Java
- **Platform**: Android OS
- **IDE**: Android Studio
- **Setup**: Import the files into your app's `src/main` directory, build the project, and run it on an emulator or physical device to inspect the Toast notifications as you navigate.
