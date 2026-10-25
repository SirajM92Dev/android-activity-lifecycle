# Android Activity Lifecycle & Bidirectional Intent Data Passing

A complete Android demonstration showcasing both the **Android Activity Lifecycle** and **bidirectional data passing** between two activities (`MainActivity` and `SecondActivity`) using explicit `Intent`s.

---

## 📌 Project Overview

This project serves two main educational purposes in Android development:

1. **Activity Lifecycle Observation**: Visualizes state transitions across all 7 lifecycle callbacks using custom `Toast` notifications.
   - `MainActivity` displays default bottom-aligned toasts.
   - `SecondActivity` displays center-screen toasts to avoid visual overlap.
2. **Bidirectional Intent Data Passing**:
   - **Forward Passing**: `MainActivity` captures user text input and sends it to `SecondActivity` via `Intent.putExtra()`.
   - **Backward Passing**: `SecondActivity` captures a response message, packages it into a result `Intent` using `setResult()`, and sends it back to `MainActivity` upon finishing, where it is received via `ActivityResultLauncher`.

---

## 🔄 Lifecycle Methods Implemented

Both activities implement and track all fundamental lifecycle callbacks:

| Callback | Description |
| :--- | :--- |
| `onCreate()` | Initializes UI layouts, click listeners, and extracts Intent extras. |
| `onStart()` | Triggers when the activity becomes visible to the user. |
| `onResume()` | Triggers when the activity enters the foreground and is interactive. |
| `onPause()` | Called when the activity is partially obscured or losing focus. |
| `onStop()` | Called when the activity is no longer visible on screen. |
| `onRestart()` | Invoked when returning to a stopped activity before restarting it. |
| `onDestroy()` | Final cleanup before the activity is removed from memory. |

---

## 🔁 Data Flow Architecture

```text
[ MainActivity ]
       │
       │  1. Forward Data:
       │     intent.putExtra("EXTRA_FORWARD_DATA", inputMessage);
       │     secondActivityLauncher.launch(intent);
       ▼
[ SecondActivity ]
       │
       │  2. Receive & Display:
       │     getIntent().getStringExtra("EXTRA_FORWARD_DATA");
       │
       │  3. Backward Data:
       │     Intent returnIntent = new Intent();
       │     returnIntent.putExtra("EXTRA_REPLY_DATA", replyMessage);
       │     setResult(RESULT_OK, returnIntent);
       │     finish();
       ▼
[ MainActivity ]
       │
       └─► 4. Handle Result:
              secondActivityLauncher receives callback:
              result.getData().getStringExtra("EXTRA_REPLY_DATA");
              Updates tvReturnedData view.
