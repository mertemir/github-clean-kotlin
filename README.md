Android app for showing the Kotlin users from the Github API on an infinite recyclerview. The detailed information about the users can be reached by clicking the items.

Patterns

Clean Architecture
MVVM
Repository
Observer
Technology Stack

Kotlin
Dagger 2
RxAndroid/RxKotlin
Retrofit 2
Android Jetpack
LiveData
ViewModel
Paging Library
ConstraintLayout
Picasso
Choices made while developing:

For decoupling the business logic from the presentation and data layers, the project is implemented with the Clean Architecture.
The domain layer has no dependency to the Android Framework, thus the reusability and testability is achieved.
Communication between the layers are done by the interfaces. The implementations are provided and injected with Dagger.
Repository class serving as the single source of truth and providing the persistence of data throughout the application.
Remote and local data access are done here.
Rx library is used for threading and reactive programming purposes.
Responses from the api are handled as singles and implemented accordingly.
LiveData and ViewModel are used for observing the data from the UI.
Whenever new data is emitted, the change can be received by observing the LiveData.
The data is persisted from the screen rotations.
Paging library is used for the infinite scrolls.
I have chosen to implement the data source with PageKeyedDataSource, because the Github API needs page numbers in order to keep sending the new users.