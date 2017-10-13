### Sudoku Solver

A human-like Sudoku solver, i.e. instead of using well-known algorithmic solving techniques, the solver tries to look at rows, columns, and 3x3 squares to narrow down possibilities of each cell, as well as (hopefully) making a few guesses by trial and error. This should hopefully allow for a quick and easy implementation of a "trainer" that could teach a real human the tricks of solving a sudoku and giving hints.

Currently, a few things that needs work on:

1. **A parser for a sudoku file formats.** There are many sudoku file formats out there but I can't seem to find a large bulk download for them for testing, hence I haven't started a parser.
2. **Implementation of trial and error guesses when further progress by elimination is no longer possible**. I haven't decided how to do this yet, but checking the condition that no progress has been made since the last iteration should be trivial
3. Fix the bug affecting how many cells left are counted.
