@echo off
@echo package reporting; >EmailSubject.java
@echo public class EmailSubject { >>EmailSubject.java
@echo public static String buildNum = "%*";>>EmailSubject.java
@echo } >>EmailSubject.java
@echo end