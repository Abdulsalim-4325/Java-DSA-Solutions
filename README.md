# Data Structures & Algorithms (DSA) Tracker 🚀

Welcome to my central repository for tracking core Data Structures and Algorithms problems. This repository serves as a daily practice laboratory focused on refining asymptotic runtime efficiencies (\(O(N)\)), micro-optimizations, memory footprints, and architectural clean-coding practices in Java.

## 📂 Repository Structure

The architecture of this repository separates problems by foundational data structures and algorithm paradigms for seamless scalability.

```text
.
├── 📂 Arrays/
│   ├── 📜 Single_Number.java                  # Bitwise XOR evaluation (LC-Easy)
│   └── 📜 Two_sum.java                        # Companion hashing index map (LC-Easy)
├── 📂 Linked_List/
│   └── 📜 Merge_Two_Sorted_Lists.java         # Sentinel node pointer splicing (LC-Easy)
├── 📂 Search-Algorithms/
│   ├── 📜 BinarySearch.java                   # Iterative interval reduction (LC-Easy)
│   └── 📜 RecursiveBinarySearch.java          # Call-stack divide & conquer (LC-Easy)
└── 📂 Extra_Questions/
    ├── 📜 Add_Binary.java                     # Bit-by-bit ripple carry simulation (LC-Easy)
    ├── 📜 Best_Time_To_Buy_And_Sell_Stock.java # Single-pass greedy peak-valley tracking (LC-Easy)
    ├── 📜 Integer_To_Roman.java               # Decreasing radix baseline subtraction (LC-Medium)
    ├── 📜 Longest_Common_Prefix.java          # Horizontal scanning compaction match (LC-Easy)
    ├── 📜 Missing_Numbers.java                # Gauss sum vs accumulation arithmetic (LC-Easy)
    ├── 📜 Palindrome_Number.java              # Integer inversion check without strings (LC-Easy)
    ├── 📜 Plus_One.java                       # Array-based backward carry cascade (LC-Easy)
    ├── 📜 Reverse_Integer.java                # Overflow-guarded 32-bit digit extraction (LC-Medium)
    ├── 📜 Roman_TO_Integer.java               # Look-ahead contextual subtraction parsing (LC-Easy)
    ├── 📜 Square_Root_Of_X.java               # Non-linear monotonic binary search boundary (LC-Easy)
    ├── 📜 Valid_Palindrome.java               # Double-ended filtering pointer iteration (LC-Easy)
    └── 📜 Valid_Parenthesis.java              # Stack-based linear bracket balance map (LC-Easy)
```

---

## 📊 Technical Problem Matrix

| Problem File | Core Technique / Pattern | Time Complexity | Space Complexity | Platform Category |
| :--- | :--- | :---: | :---: | :---: |
| **`Single_Number.java`** | Bit Manipulation (XOR `^`) | $O(N)$ | $O(1)$ | LeetCode Easy |
| **`Two_sum.java`** | Complement Hashing (`HashMap`) | $O(N)$ | $O(N)$ | LeetCode Easy |
| **`Merge_Two_Sorted_Lists.java`** | Two-Pointer / Sentinel Node Splicing | $O(N + M)$ | $O(1)$ | LeetCode Easy |
| **`BinarySearch.java`** | Two-Pointer Interval Bisection | $O(\log N)$ | $O(1)$ | LeetCode Easy |
| **`RecursiveBinarySearch.java`** | Divide-and-Conquer Recurrence | $O(\log N)$ | $O(\log N)$ | LeetCode Easy |
| **`Add_Binary.java`** | Two-Pointer Array Arithmetic Simulation | $O(\max(N, M))$ | $O(1)$ | LeetCode Easy |
| **`Best_Time_To_Buy_And_Sell_Stock.java`**| Greedy Scan / Local Minimum Tracking | $O(N)$ | $O(1)$ | LeetCode Easy |
| **`Integer_To_Roman.java`** | Greedy Linear Threshold Match | $O(1)$ | $O(1)$ | LeetCode Medium |
| **`Longest_Common_Prefix.java`** | Horizontal Prefix Truncation Scan | $O(S)$ | $O(1)$ | LeetCode Easy |
| **`Missing_Numbers.java`** | Mathematical Formula (Gauss Series Sum) | $O(N)$ | $O(1)$ | LeetCode Easy |
| **`Palindrome_Number.java`** | Digit Modulo Reflection Logic | $O(\log_{10} N)$| $O(1)$ | LeetCode Easy |
| **`Plus_One.java`** | Ripple Carry Array Simulation | $O(N)$ | $O(1)$ | LeetCode Easy |
| **`Reverse_Integer.java`** | Overflow-Aware Bit Boundary Guarding | $O(\log_{10} N)$| $O(1)$ | LeetCode Medium |
| **`Roman_TO_Integer.java`** | Forward-Looking Contextual Subtract | $O(N)$ | $O(1)$ | LeetCode Easy |
| **`Square_Root_Of_X.java`** | Integer Domain Binary Space Search | $O(\log N)$ | $O(1)$ | LeetCode Easy |
| **`Valid_Palindrome.java`** | In-Place Two-Pointer Alphanumeric Filter| $O(N)$ | $O(1)$ | LeetCode Easy |
| **`Valid_Parenthesis.java`** | Linear Dynamic Stack Matching (`Stack`) | $O(N)$ | $O(N)$ | LeetCode Easy |

---

## 🛠️ Compilation & Execution Guidelines

These solutions are engineered as standalone drivers featuring bundled execution suites inside their respective `main` frameworks, optimized for direct instantiation within **Visual Studio Code**.

### Requirements
- **Java Development Kit (JDK)**: Version 11 or higher recommended.
- **VS Code Extensions**: *Extension Pack for Java* (by Microsoft).

### Execution Flow via Terminal
To test code logic directly without a full build runner, navigate to the target module directory and execute:

```bash
# Navigate to subfolder
cd Extra_Questions

# Compile the driver code
javac Plus_One.java

# Execute the bytecode target
java Plus_One
```

---

## 📈 Engineering Log Notes & Insights

- **Avoiding Intermediate Allocations:** In string parsing problems like `Valid_Palindrome.java`, I leveraged an in-place bidirectional pointer approach instead of relying on regex replacements (`s.replaceAll(...)`). This avoids unnecessary string allocations on the heap, maintaining low memory consumption ($O(1)$ auxiliary space).
- **Handling Integer Overflow Thresholds:** In `Reverse_Integer.java`, checking constraints using `Integer.MAX_VALUE / 10` *prior* to compounding the arithmetic calculation guarantees protection against 32-bit internal register wrap-around errors without resorting to 64-bit `long` types.
- **Bitwise Logic Optimization:** For `Single_Number.java`, utilizing the commutative property of the XOR operator ($A \oplus B \oplus A = B$) allowed me to find the unrepeated element in a single pass without using memory-intensive hash tables.

---
💡 *This workspace is iteratively updated on a daily basis with new algorithm optimizations and clean design patterns.*
