# University Student Record and Campus Route Management System

## Module
CIT300 - Data Structures and Algorithms

## Project
University Student Record and Campus Route Management System

## Group Members

| Member | Student ID | GitHub login email | Responsibility |
|---|---|---|---|
| Member 01 | 22UG3-0238 | 22ug3-0238@sltc.ac.lk | Linked List and Student Record Management |
| Member 02 | 22UG3-0145 | 22ug3-0145@sltc.ac.lk | Stack, Queue and related operations |
| Member 03 | 22UG3-0425 | 22ug3-0425@sltc.ac.lk | BST and Hashing/Search |
| Member 04 | 22UG3-0427 | 22ug3-0427@sltc.ac.lk | Graph, Campus Locations, Connections, BFS/DFS |

## Individual Contributions

### Member 01 - 22UG3-0238 Buddika Isuru
- Student model class.
- Student linked list.
- Add, update, delete, search and display support through the student-record layer.
- Contributed to integration and testing.

### Member 02 - 22UG3-0145 T.I. Gunasinghe
- Action stack.
- Service request queue.
- Recent action and service-request operations.
- Contributed to integration, validation and testing.

### Member 03 - 22UG3-0425 J.R.P.K. Jayalath
- Student BST.
- Hash table.
- BST display and hashing search.
- Contributed to integration and testing.

### Member 04 - 22UG3-0427 J.R.T.D. Jayalath
- Campus graph using adjacency list.
- Add/remove locations.
- Add/remove connections.
- Campus network display.
- BFS and DFS traversal.
- Contributed to integration and testing.

## Required Data Structures
- Linked List
- Stack
- Queue
- Binary Search Tree (BST)
- Hash Table
- Graph using adjacency list
- BFS and DFS traversal

## Project Structure

```text
UniversityStudentCampusSystem/
├── src/
│   ├── app/
│   │   └── Main.java
│   ├── model/
│   │   └── Student.java
│   └── datastructures/
│       ├── StudentLinkedList.java
│       ├── ActionStack.java
│       ├── ServiceQueue.java
│       ├── StudentBST.java
│       ├── StudentHashTable.java
│       └── CampusGraph.java
├── .gitignore
└── README.md
```

## How to Run

### Windows
Open the project folder in VS Code terminal:

```bash
javac -d out src/model/Student.java src/datastructures/*.java src/app/Main.java
java -cp out app.Main
```

### Linux/macOS
Use the same commands in a terminal:

```bash
javac -d out src/model/Student.java src/datastructures/*.java src/app/Main.java
java -cp out app.Main
```

Java JDK must be installed and `java`/`javac` must be available in PATH.

## Main Menu
1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Recent Actions using Stack
8. Display Students using BST
9. Search Student using Hashing
10. Add Campus Location
11. Remove Campus Location
12. Add Campus Connection/Road
13. Remove Campus Connection/Road
14. Display Campus Connections
15. Traverse Campus Locations using BFS/DFS
16. Exit

## Validation
The application:
- Rejects empty text input.
- Validates menu numbers.
- Validates marks from 0 to 100.
- Rejects duplicate student IDs.
- Handles missing student records.
- Handles duplicate/missing campus locations and connections.
- Rejects a connection from a location to itself.

## GitHub Collaboration Evidence
Each member should create a branch, make meaningful commits for their own work, push the branch, and create a pull request to `main`. The team should merge the pull requests after review. Keep screenshots of:
1. Repository main page.
2. Each member's branch.
3. Each member's meaningful commits.
4. Pull requests.
5. Merged pull requests.
6. Final project running in VS Code terminal.

## Demo Video
Create one merged video. Every member must appear and demonstrate their own contribution:
- Member 01: student records and linked list.
- Member 02: stack and queue.
- Member 03: BST and hashing.
- Member 04: graph, connections, BFS/DFS.
- End with the integrated full system and GitHub repository.

## Important
Do not claim a feature was individually developed by a member if that member did not actually contribute it. Git history, branches, commits and the README should match the actual work done by the group.
