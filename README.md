# Math Quiz App

Math Quiz App is an Android application that quizzes users on math problems of varying difficulty levels.

## Features

- Three difficulty levels: Easy, Medium, and Hard.
- Randomly generated math problems.
- Timed quiz with a countdown timer.
- Score tracking and summary at the end of each quiz.
- Option to review correct answers after completing the quiz.
- Responsive design for both phones and tablets.

## Usage
- Choose a difficulty level (Easy, Medium, Hard).
- Start the quiz and answer the math problems within the given time.
- Select an answer from multiple-choice options for each problem.
- Track your score and see a summary of correct answers at the end.
- Review correct answers and explanations for each question.

## Architecture and Implementation
Math Quiz App is built using Kotlin and utilizes Android Jetpack components such as ViewModel, LiveData, and Room Database. Key implementation details include:

- RecyclerView for displaying quiz questions and options.
- Countdown timer using CountDownTimer class for quiz time management.
- Local storage of quiz data using Room Database for offline access.

## Design Patterns

- Consider applying design patterns like MVVM (Model-View-ViewModel) to separate concerns and make your codebase more maintainable and testable.
