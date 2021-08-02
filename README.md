# PrototypeArch
Prototype of architecture of android application. The skeleton of a good app :3
The project was developed within the framework of prototyping the architecture of building an application, reusing practices and developments in the code base.

# Stack

- MVVM/MVI
- Kotlin Coroutines/Flow
- Retrofit
- Navigation Components
- Koin

# Modules

- :app - The main module for implementing the application.
- :core - module for reusable code, extensions and utilities.
- :core_data - module for implementing repositories for working with data.
- :core_network - module for networking and working with external data sources via HTTP / other protocols
- :core_db - module for database implementation and work with it
- :result - lib for retrofit to wrap result (optional)
- :retrofit-result - lib for resultAdapter for Retrofit (optional)

# Features

- UseCaseResult for Retrofit
- FlowPreferences
- BottomNavigation
- SingleActivity
- NoRx :D
- DI with Koin
