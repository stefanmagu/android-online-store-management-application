# Online Store Management Application

## Description

The Online Store Management Application is an Android app that allows users to browse and interact with products in an online store. Users can log in, register, view product details, add reviews, and manage their account. The app uses a local Room database for data persistence and includes features for data transfer between activities and filtering products.

## Features

*   **Product Browsing:** Users can view a list of available products.
*   **Product Details:** Users can view detailed information about each product.
*   **Reviews:** Users can add reviews for products.
*   **Vouchers:** The app supports the use of vouchers.
*   **Login/Registration:** Users can log in with existing credentials or register a new account.
*   **Review Submission:** Users can submit reviews for products.
*   **Data Transfer:** Data is transferred between different activities.
*   **Local Database:** The app uses a Room database for local data storage.
*   **JSON Data:** The app is designed to handle data from a network in JSON format (although the current implementation does not fetch data from a network).
*   **Product Filtering:** Products can be filtered in ListViews.
*   **Logout:** Users can log out of their accounts.
* **Shared Preferences:** The app uses shared preferences to store the logged user.

## Screenshots

*   **Login Screen:** Shows the login form with fields for username and password.
![Screenshot 2025-05-02 133556](https://github.com/user-attachments/assets/26297ee3-f443-4b21-aec6-5f7af2ce9e2c)

*   **Registration Screen:** Shows the registration form with fields for name, surname and password.
  
![Screenshot 2025-05-02 133613](https://github.com/user-attachments/assets/7527dc03-3d99-4216-af48-c26d3b488714)

*   **Product List:** Shows a list of products available in the store.

![Screenshot 2025-05-02 133640](https://github.com/user-attachments/assets/1dee2b3d-3285-4fc1-86d0-4949833c810e)
![Screenshot 2025-05-02 133651](https://github.com/user-attachments/assets/215b2805-2794-48a5-a397-dd64838726c9)

*   **Product Details:** Shows detailed information about a specific product.

![Screenshot 2025-05-02 133749](https://github.com/user-attachments/assets/8a44b6ae-2859-4bdd-b819-ad90296e00a0)

*   **Review Form:** Shows the form for submitting a review.

![Screenshot 2025-05-02 133724](https://github.com/user-attachments/assets/ce38c5b2-5689-428b-b5fa-c4507fde33e2)
![Screenshot 2025-05-02 133704](https://github.com/user-attachments/assets/2d588eed-3964-4b3a-9cf3-68f128a791cd)

## Architecture

This project follows a basic architectural pattern that separates concerns:

*   **Activities:** Handle user interactions and UI updates.
*   **Room Database:** Manages local data storage and retrieval.
*   **DAO (Data Access Objects):** Provide an interface for interacting with the Room database.
*   **Models:** Represent the data structures (e.g., `Utilizator`).
* **Shared Preferences:** Stores the logged user data.

## Setup Instructions

1.  **Clone the repository:**

2.  **Open in Android Studio:**
    *   Open Android Studio and select "Open an Existing Project."
    *   Navigate to the cloned directory and select it.
3.  **Build and Run:**
    *   Click the "Run" button in Android Studio.
    *   Select an emulator or a connected device.

## Dependencies

The project uses the following dependencies:

*   `androidx.appcompat:appcompat:1.6.1`
*   `androidx.activity:activity:1.8.0`
*   `androidx.core:core:1.9.0`
*   `androidx.annotation:annotation-experimental:1.3.0`
*   `androidx.lifecycle:lifecycle-runtime:2.6.1`
*   `androidx.versionedparcelable:versionedparcelable:1.1.1`
*   `androidx.lifecycle:lifecycle-viewmodel:2.6.1`
*   `androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.1`
*   `androidx.core:core-ktx:1.9.0`
*   `androidx.lifecycle:lifecycle-livedata-core:2.6.1`
*   `androidx.savedstate:savedstate:1.2.1`
*   `androidx.appcompat:appcompat-resources:1.6.1`
*   `androidx.vectordrawable:vectordrawable:1.1.0`
*   `androidx.vectordrawable:vectordrawable-animated:1.1.0`
*   `androidx.interpolator:interpolator:1.0.0`
*   `androidx.cursoradapter:cursoradapter:1.0.0`
*   `androidx.drawerlayout:drawerlayout:1.1.1`
*   `androidx.customview:customview:1.1.0`
*   `androidx.fragment:fragment:1.3.6`
*   `androidx.viewpager:viewpager:1.0.0`
*   `androidx.loader:loader:1.0.0`
*   `androidx.lifecycle:lifecycle-livedata:2.6.1`
*   `androidx.arch.core:core-runtime:2.2.0`
*   `androidx.cardview:cardview:1.0.0`
*   `androidx.coordinatorlayout:coordinatorlayout:1.1.0`


## Contribution Guidelines

*(Optional)*

We welcome contributions! If you'd like to contribute, please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and commit them.
4.  Submit a pull request.


### Requirements

To run the Online Store Management Application, you will need the following:

*   **Android Studio:** Installed on your machine (You can install the SDK and AVD via the wizard installer).
*   **Android SDK:** Properly configured within Android Studio.
*   **Android Virtual Device (AVD):** A compatible AVD set up in Android Studio, *or*
*   **Physical Android Device:** A physical Android device connected to your computer for testing.
*   **Git:** Installed on your machine to clone the project repository.

### Steps to Run the App

1.  **Clone the Repository.**
2.  **Open in Android Studio:**
    *   Launch Android Studio.
    *   Select `Open an Existing Project`.
    *   Navigate to the directory where you cloned the repository and select it.
3.  **Gradle Sync:**
    *   Once the project is loaded, allow Android Studio to sync the **Gradle** files and download any necessary dependencies.
4.  **Build the Project:**
    *   After the sync is complete, go to `Build` > `Make Project`.
5.  **Run the App:**
    *   Click the `Run` button (green play icon).
    *   Choose your desired AVD or connected device.
6. **Installation:**
    * The app will then install and run on your selected device, allowing you to interact with its features.
