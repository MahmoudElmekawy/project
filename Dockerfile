FROM openjdk

WORKDIR /application

COPY TicTacToe2.java .


RUN javac TicTacToe2.java

CMD java TicTacToe2