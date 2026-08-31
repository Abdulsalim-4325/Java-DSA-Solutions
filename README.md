# Data Structures & Algorithms (DSA) Tracker

A structured Java repository for practising core data structures, algorithms, and problem-solving patterns. Each problem is maintained as a standalone, runnable Java program with a problem-based class name, explanatory comments, and sample test cases for local execution in Visual Studio Code.

The repository currently indexes **80 solved problems**. Files are organised by their **primary algorithmic technique** so that revision remains predictable as the collection grows. A solution may use supporting ideas from another category; its folder reflects the dominant technique.

## Repository Design Principles

- **Correctness first:** solutions are designed to handle boundary conditions and platform constraints.
- **Optimal asymptotic design:** each implementation targets the expected optimal time and auxiliary-space complexity.
- **Standalone Java execution:** every file can be compiled and executed independently; no package declaration is required.
- **Clean source organisation:** folders represent primary DSA categories rather than a catch-all collection of questions.
- **Traceable commits:** commits follow `DSA (Platform - Difficulty) | Added <Problem Name> solution in Java`.

## Repository Structure

```text
.
├── Arrays/
│   ├── Best_Time_To_Buy_And_Sell_Stock.java
│   ├── Find_Missing_Elements.java
│   ├── Length_Of_Longest_Subarray_With_At_Most_K_Frequency.java
│   ├── Max_Sum_Subarray_Of_Size_At_Least_K.java
│   ├── Maximum_Product_Of_Three_Numbers.java
│   ├── Maximum_Product_Of_Two_Elements_In_An_Array.java
│   ├── Min_Product_Subset.java
│   ├── Pairs_With_Less_Than_K_Diff.java
│   ├── Plus_One.java
│   ├── Remove_Duplicates_From_Sorted_Array.java
│   ├── Remove_Element.java
│   ├── Removing_Minimum_and_Maximum_From_Array.java
│   ├── Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum.java
│   └── Split_Array_Into_Minimum_Subsets.java
├── Binary_Search/
│   ├── BinarySearch.java
│   ├── Median_Of_Two_Sorted_Arrays.java
│   ├── RecursiveBinarySearch.java
│   ├── Search_Insert_Position.java
│   └── Square_Root_Of_X.java
├── Bit_Manipulation/
│   ├── Longest_Subsequence_With_Non_Zero_Bitwise_XOR.java
│   ├── Maximum_Subset_XOR.java
│   ├── Number_Of_Unique_XOR_Triplets_I.java
│   ├── Number_Of_Unique_XOR_Triplets_II.java
│   └── Single_Number.java
├── Dynamic_Programming/
│   ├── Count_Arrays_With_Divisible_Adjacent_Elements.java
│   ├── Count_Subsequences_Divisible_by_n.java
│   ├── Friends_Pairing_Problem.java
│   ├── GFG_Adventure_In_A_Maze.java
│   ├── High_Effort_vs_Low_Effort.java
│   ├── Largest_Zigzag_Sequence.java
│   ├── Minimum_Cost_Selection.java
│   ├── Minimum_Cost_for_n_Characters.java
│   ├── Minimum_Increment_Or_Double_Operations_To_Convert.java
│   ├── Predict_The_Winner.java
│   ├── Stone_Game_II.java
│   ├── Stone_Game_III.java
│   ├── Stone_Game_IV.java
│   ├── Stone_Game_V.java
│   └── Subset_Sum_On_Generated_Sequence.java
├── Game_Theory/
│   ├── Stone_Game.java
│   └── Stone_Game_IX.java
├── Graphs/
│   ├── Longest_Path_In_A_Directed_Acyclic_Graph.java
│   ├── Min_Edge_Movements_To_Connect_A_Graph.java
│   ├── Remove_Methods_From_Project.java
│   ├── Shortest_Path_In_1_2_Graph.java
│   └── Snake_And_Ladder_Problem.java
├── Hashing/
│   ├── Contains_Duplicate_II.java
│   └── Two_sum.java
├── Linked_List/
│   └── Merge_Two_Sorted_Lists.java
├── Math/
│   ├── Find_Greatest_Common_Divisor_Of_Array.java
│   ├── Integer_To_Roman.java
│   ├── Maximum_Product_Of_Two_Digits.java
│   ├── Missing_Numbers.java
│   ├── Numbers_Without_Digit.java
│   ├── Palindrome_Number.java
│   ├── Reverse_Integer.java
│   ├── Roman_TO_Integer.java
│   └── Smallest_Divisible_Digit_Product_I.java
├── Prefix_Sum/
│   ├── Largest_Odd_Squares_with_Limited_1s.java
│   ├── Maximum_Sum_Of_K_X_K_Sub_Grid.java
│   ├── Maximum_Value_After_Range_Increment_Operations.java
│   └── Subarrays_With_Sum_In_Range.java
├── Segment_Tree/
│   └── Longest_Substring_Of_One_Repeating_Character.java
├── Sorting/
│   ├── Make_Lexicographically_Smallest_Array_by_Swapping_Elements.java
│   └── Marks_from_Ranks.java
├── Stack/
