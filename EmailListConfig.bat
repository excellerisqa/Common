@echo off
@echo package reporting; >EmailList.java
@echo public class EmailList { >>EmailList.java
@echo public static String email = "%*";>>EmailList.java
@echo } >>EmailList.java
@echo end