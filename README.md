# junit5
Study material about **junt5**

## Headings
- '# The largest heading'
- '## The second largest heading'
- '###### The smallest heading'

**This is bold text**

*This text is italicized*

~~This was mistaken text~~

**This text is _extremely_ important** bold and italic

## Quoting text
> Pardon my french

## Quoting code
Use `git status` to list all new or modified files that haven't yet been committed.

code block, placing a blank line before and after code blocks to make the 
raw formatting easier to read.

```
git status
git add
git commit
```

add an optional language identifier to enable syntax highlighting  

```ruby
require 'redcarpet'
markdown = Redcarpet.new("Hello World!")
puts markdown.to_html
```

##Links
This site was built using [GitHub Page](https://pages.github.com/)

##Relative links
相对链接，链接到库中其他文件，例如
[Contribution guidelines for this project](docs/CONTRIBUTING.md)
链接到docs目录下的CONTRIBUTING.md 文件。

##Lists
make a list by preceding one or more lines of text with -  or *.
- George Washington
- John Adams
- Thomas Jefferson

Order list, precede each line with a number.
1. James Madison
2. James Monroe
3. John Quincy Adams

Nested lists by identing lines by two spaces
1. Make my changes
    1. Fix bug
    2. Improve formatting
        * Make the headings bigger
 2. Push my commits to GitHub

##Task lists
preface list items with [ ], To mark a task as complete, use [x]
- [x] Finish my changes
- [ ] Push my commits to Github
- [ ] Open a pull request

If a task list item description begins with a parenthesis, you'll need to esacpe it with \:
- [ ] \(Optional) open a followup issue

## at users and teams
@github/support What do you think about these updates?

## Paragraphcs and line breaks
Create a new paragraph by leaving a blank line between lines of text.

##Ignoring Markdown
ignore markdown formatting by using \ before the markdown character.

## Creating a table
|First Header|Second Header |
|---|---|
| Content Cell | Content Cell |

## formatting content within your table
| Commang | Description
|---|----|
|`Git status`| List all * new of modified* files|
|`git diff` | Show file difference that **haven't been** staged|

|Left-aligned| Center-aligned|Right-aligned|
|:---|:---:|---:|
|git status|git status|git status|
|git diff|git diff|git diff|

