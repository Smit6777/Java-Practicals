# Object-Oriented Programming with Java (CEUE203) - Practical List (Part A)

A structured collection of Java laboratory practice programs developed as part of the Object-Oriented Programming (CEUE203) coursework. This repository covers core Java concepts ranging from fundamental syntax and OOP to multithreading, concurrency utilities, modern NIO file handling, collections, and generic data structures across practical sessions 1 to 13.

---

## Student Details

- **Name:** Smit Makwana
- **Roll No:** 25IT052
- **Subject:** Object-Oriented Programming with Java (CEUE203)

---

## Directory & Practicals Overview

All practicals are organized in sequenced folders (`pr01` to `pr13`):

```text
Java-Practicals/
├── pr01/                     # Basic Setup, Enums, Switch Expressions, Records
│   ├── VendingMachine.java   # Coin enum & switch expression
│   ├── TollBooth.java        # Vehicle record & toll switch expression
│   └── RPSLS.java            # Rock-Paper-Scissors-Lizard-Spock game
├── pr02/                     # Encapsulation & Constructor Chaining
│   ├── Thermostat.java       # Temperature control & chaining with this(...)
│   ├── CinemaShow.java       # Seat booking & cancellation logic
│   └── ParkingLot.java       # Two/four-wheeler counts & revenue tracking
├── pr03/                     # Overriding Object Methods
│   ├── DistinctPoints.java   # 2D coordinate comparison (equals/hashCode)
│   ├── DuplicateCardCheck.java # Duplicate card check
│   └── FractionDemo.java     # Fraction class reduced by GCD
├── pr04/                     # Strings, StringBuilder & Regular Expressions
│   ├── PasswordChecker.java  # Regex-based password strength evaluator
│   ├── ChatFilter.java       # Log splitting & case-insensitive keyword filtering
│   └── TemplateFiller.java   # Placeholder replacement using Pattern & Matcher
├── pr05/                     # Inheritance, Abstract Classes & Polymorphism
│   ├── ShapeDemo.java        # Shape hierarchy (Circle, Rectangle, Triangle)
│   ├── Employee.java         # Payroll hierarchy with instanceof check
│   └── LateFeeDemo.java      # Library media late fee calculations
├── pr06/                     # Interfaces, Lambdas & Marker Interfaces
│   ├── RemoteControlDemo.java# Switchable interface with default toggle() & lambdas
│   └── NotificationDemo.java # Functional Notifier & Urgent marker interface
├── pr07/                     # Custom Annotations & Reflection Engine
│   ├── FormValidator.java    # @NotBlank, @MaxLength runtime reflection validator
│   ├── MiniTestRunner.java   # @Run annotation custom test runner
│   └── ColumnMapper.java     # @Column reflection mapping to object fields
├── pr08/                     # Custom Exceptions & Resource Management
│   ├── GuardedCalculator.java# Custom DivideByZeroException with try-catch-finally
│   ├── StockIssue.java       # OutOfStockException & shortfall calculation
│   └── AutoCloseableDemo.java# AutoCloseable resource with try-with-resources
├── pr09/                     # Multithreading & Synchronization
│   ├── CounterRace.java      # Race conditions vs synchronized methods
│   ├── SeatBookingRace.java  # Thread safety in ticket reservation
│   └── SharedTotalRace.java  # Multi-threaded array summing with AtomicLong
├── pr10/                    # Concurrency Utilities & Thread Pools
│   ├── ThreadPoolDemo.java   # ExecutorService fixed thread pool execution
│   ├── ProducerConsumerDemo.java # Shared buffer coordination (wait/notify)
│   └── DeadlockDemo.java     # Deadlock reproduction and lock ordering fix
├── pr11/                    # Serialization & Modern NIO
│   ├── SaveLoad.java         # Serializable objects with transient fields
│   ├── LogAnalyzer.java      # Log analysis using Path and Files API
│   └── FolderReport.java     # Directory tree walk and metadata reporting
├── pr12/                    # Collections Framework
│   ├── WordFrequency.java    # Word frequency map sorted with Comparator
│   ├── UniqueVisitors.java   # HashSet and LinkedHashSet order preservation
│   └── Leaderboard.java      # Scoreboard sorting with custom tie-breaking
└── pr13/                    # Generics & Bounded Types
    ├── GenericContainers.java# Generic Box<T>, Pair<A, B>, and generic methods
    ├── BoundedStats.java     # Bounded generic <N extends Number> average
    └── GenericStackDemo.java # Array-backed generic Stack implementation
```

---

## Practicals Covered

| Lab | Topic | Description |
| :---: | :--- | :--- |
| **PR01** | Basic Setup, Enums & Switch Expressions | Enum-driven vending machine, vehicle toll record, and RPSLS game using modern switch expressions. |
| **PR02** | Encapsulation & Constructor Chaining | State encapsulation, static counters, and constructor chaining with `this(...)`. |
| **PR03** | Overriding Object Methods | Implementing the contract between `equals()`, `hashCode()`, and `toString()`. |
| **PR04** | Strings, Regex & Pattern Matching | Robust input validation, tokenizing with `split()`, and regex group replacement. |
| **PR05** | Inheritance & Polymorphism | Abstract classes, dynamic method dispatch across polymorphic arrays, and `instanceof`. |
| **PR06** | Interfaces & Lambdas | Default methods, functional interfaces, lambda expressions, and marker interfaces. |
| **PR07** | Custom Annotations & Reflection | Defining `@Target` and `@Retention` annotations and inspecting fields/methods reflectively. |
| **PR08** | Custom Exceptions & Resource Handling | Checked exceptions, exception hierarchies with custom fields, and `try-with-resources`. |
| **PR09** | Multithreading & Synchronization | Investigating race conditions on shared memory and making critical sections thread-safe. |
| **PR10** | Thread Pools & Concurrency Coordination | Managed task execution with `ExecutorService`, producer-consumer using `wait()`/`notify()`, and deadlock prevention. |
| **PR11** | Serialization & Modern Java NIO | Binary object persistence using `ObjectOutputStream` and file operations with `java.nio.file`. |
| **PR12** | Java Collections Framework | Efficient lookups, insertion-ordered sets, and multi-key custom sorting using `Comparator`. |
| **PR13** | Generic Classes & Bounded Type Parameters | Type-safe containers, generic methods, and upper-bounded constraints (`<N extends Number>`). |

---

---

> **SMIT MAKWANA**  
> **ID: 25IT052**
