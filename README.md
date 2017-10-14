### Sudoku Solver

A human-like Sudoku solver, i.e. instead of using well-known algorithmic solving techniques, the solver tries to look at rows, columns, and 3x3 squares to narrow down possibilities of each cell, as well as (hopefully) making a few guesses by trial and error. This should hopefully allow for a quick and easy implementation of a "trainer" that could teach a real human the tricks of solving a sudoku and giving hints.

Currently, a few things that needs work on:

1. **A parser for a sudoku file formats.** There are many sudoku file formats out there but I can't seem to find a large bulk download for them for testing, hence I haven't started a parser.
2. **Implementation of trial and error guesses when further progress by cell possibility elimination is no longer possible**. I haven't decided how to do this yet, but checking the condition that no progress has been made since the last iteration ~~should be trivial~~ is currently being done with how many cells are left, but it might be better to check board states by hashing the board array and comparing. That will likely have quite a big performance impact, though. The actual implementation of a game-state "stack" might also require some refactoring, i.e. change Game to a GameState, or something. I'm not sure.
3. ~~Fix the bug affecting how many cells left are counted.~~ Done!
4. Add multi-threading/concurrency.
5. Add running options (i.e. running the program with flags will enable/disable multithreading, not use guessing, etc)
