# MuzzExercise

## Architecture
I have split the app into data, domain and ui layers.
The ui and data layers both depend on the domain layer and the domain layer does not depend on either of the other layers.

* Data
  * Database
  * Repository implementation
* Domain
  * Repository interface
  * UseCases
* Ui
  * ViewModel
  * Activity
  * Composables

## Implementation Decisions
* MVVM design pattern
* Compose for the UI
* Not using Navigation components as the app is only one screen
* Hilt for dependency injection
* Coroutines
* Room for the database
* To simulate the other user sending messages, tapping on the top bar sends a message with the text "Lorem ipsum" from the other user

## Data Structure
I have separate models for the data, domain and ui layers.
The data and domain models store the text of the message, whether the message was sent by the user and the timestamp of the message.
The ui model is a sealed class.
The message model stores the text of the message and the parameters necessary to display the message (the shape of the message bubble, the alignment on the screen and the bubble colour).
The section header model stores the text to be displayed in the header.

## Testing
I have tested the logic that maps from the domain model to the ui model, writing test cases to cover the criteria for whether messages have a tail and whether the section header with the date and time is shown.

## What I would change
I forgot to commit my changes as I went along with the task and would do so if given the chance to start over.
