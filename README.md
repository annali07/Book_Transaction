# Book Transaction

The Book Transaction software allows book managers to manage books inside database.

There are 4 use cases:
1. Add book to database via an ISBN number
2. Handle purchase book request via book ID
3. Handle rent out book request via book id
4. Handle rent return book request via book id
5. Calculate revenue between 2 dates

## Installation

1. `git clone` repository.
2. Change `FILE_PATH` in `/src/main/java/data/misc_info/FilePathConstants.java` to local path.
   3. Sample FILE_PATH `    public static final String FILE_PATH = "/Users/nana/Desktop/BookTransaction/src/main/java/data/db"`
4. run `mvn clean install` in terminal.

## Usage

The API used is provided by Open Library. So, only ISBN of books recorded in https://openlibrary.org/ can be detected inside the Purchase usecase.
