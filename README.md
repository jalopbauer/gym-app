# Gym App

## Features

- [x] Exercise
    - [x] Create
    - [x] Delete
    - [ ] Image
    - [ ] Categories
      - [ ] Create
      - [ ] Delete
      - [ ] Assign
      - [ ] Filter
- [x] Routine
    - [x] Create
    - [x] Update
    - [x] Delete
    - [ ] Routine Exercise
        - [ ] Set type
            - [x] Create
            - [ ] Update
            - [x] Delete
        - [ ] Timed type
            - [ ] Create
            - [ ] Update
            - [ ] Delete
        - [ ] Reorder routine exercises
- [ ] Calendar
    - [ ] Event
        - [ ] Routine
            - [ ] Create
            - [ ] Update
            - [ ] Delete
            - [ ] Run
            - [ ] Estimated duration
- [ ] Config
    - [ ] Default values
        - [ ] Routine
            - [ ] Rest
            - [ ] Amount of sets
        - [ ] Event
          - [ ] Sunday First Day

## TODO
- [ ] Refactor project structure
  - package or subpackage
    - composable/
    - repository/
    - service/
    - viewModel/
    - subpackage/
    - subpackage/
    - ...Page.kt
  - [ ] create repository layer
  - [ ] create service layer
  - [ ] View model contain state to be saved using MutableStateFlow, Page uses remember to save UI state