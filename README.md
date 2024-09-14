# Book Transaction (A+ Project)

The Book Transaction software allows book managers to manage books inside database.

There are 6 use cases:
1. Manager logs in with username and password
2. Add book to database via an ISBN number, automatically generating a bookID
3. Purchase book from database via a bookID
4. Handle rent out book request via bookID
5. Handle rent return book request via book id
6. Calculate revenue between 2 dates via 2 dates in the form yyyy-mm-dd

## Installation

1. `git clone` repository.
2. Change `FILE_PATH` in `/src/main/java/data/misc_info/FilePathConstants.java` to local path. Sample: `FILE_PATH = "/Users/nana/Desktop/BookTransaction/src/main/java/data/db"`
3. run `mvn clean install` in the terminal.

## Usage

1. The API used is provided by Open Library. So, only ISBN of books recorded in https://openlibrary.org/ can be detected inside the Add Book usecase.
2. Valid login username and password are kept in `managers.json` inside `main > java > data > db`

## Note

The `org.junit.jupiter.api` may not be automatically detected by Maven under certain circumstances, thereby giving an error during build time.
If that is the case, please go to `File > Project Structure > Project Settings > Modules > Book Transaction > Dependencies`, scroll to the bottom, select 
`junit.jupiter.api` and `junit.jupiter.engine`, click Apply, and click OK. That should solve the issue. 
