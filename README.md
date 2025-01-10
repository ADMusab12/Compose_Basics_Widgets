<h1 align="center">Material Design UI Components</h1>
<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9.0-blue.svg" alt="Kotlin Version">
  <img src="https://img.shields.io/badge/Platform-Android-green.svg" alt="Platform">
  <img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License">
  <img src="https://img.shields.io/badge/Jetpack%20Compose-Latest-purple.svg" alt="Jetpack Compose">
</p>
<p align="center">
  <img src="/api/placeholder/800/400" alt="Project Banner">
</p>
✨ Features
<div align="center">
FeatureDescription🎨 Material Design 3Latest Material Design components and styling📱 NavigationModal drawer with custom sections⏰ Time SelectionInteractive time picker with dual modes🔘 ButtonsComplete collection of Material button types🎴 CardsVarious card styles and implementations🏷️ ChipsInteractive chip components📊 ProgressLinear and circular indicators
</div>
🚀 Implementation
kotlinCopyclass MainActivity : ComponentActivity() {
    @Composable
    fun MainScreen() {
        ModalNavigationDrawer(
            drawerContent = { DrawerContent() },
            drawerState = drawerState
        ) {
            // Your app content here
        }
    }
}
🛠️ Components
<details>
<summary>Navigation Components</summary>

Modal Navigation Drawer
Custom Drawer Sections
Top App Bar Integration

</details>
<details>
<summary>Time Selection</summary>

Interactive Time Picker
Dial/Input Mode Toggle
24-hour Format Support

</details>
<details>
<summary>Button Collection</summary>

Filled Buttons
Outlined Buttons
Text Buttons
Tonal Buttons
Elevated Buttons
Floating Action Buttons

</details>
📥 Installation

Add the dependencies to your project:

gradleCopydependencies {
    implementation 'androidx.activity:activity-compose:1.8.2'
    implementation 'androidx.compose.material3:material3:1.1.2'
    implementation 'androidx.compose.ui:ui:1.5.4'
}

Clone the repository:

bashCopygit clone https://github.com/yourusername/material-design-components.git
🎯 Usage
Navigate through different components:
kotlinCopy// Button Components
FilledTonalNavigation("Buttons") { 
    Navigation(ButtonsActivity::class.java) 
}

// Card Components
FilledTonalNavigation("CardViews") { 
    Navigation(CardViewActivity::class.java) 
}
🌟 Screenshots
<div align="center">
  <img src="/api/placeholder/200/400" alt="Screenshot 1" width="200px">
  <img src="/api/placeholder/200/400" alt="Screenshot 2" width="200px">
  <img src="/api/placeholder/200/400" alt="Screenshot 3" width="200px">
</div>
