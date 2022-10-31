
Protocol objectives:

- Compute values exchanges between a server and a client

Behavior:

- Transport protocol: TCP/UDP

- How the client find the server (addresses + port): With a discovery

- Speaking first: Client <=> "I ask you to compute ..."

- Close connection from: Server after closing 

Messages:

- Msg syntax: $((X+Y)\*(..))!

- Msg sequence: 

	- C: Hi?

	- S: Hi.

	- C: Let's start computing..

	- S: Ok, give me a number

	- C: Answer

	- S: Valid/Wrong input

		- S: If valid, Ask for operator or response accordingly

		- S: If wrong, repeat question (after X attempts, closes directly)

	- C: Answer

	- S: Check again depending on the expected things

		- S: If valid, Ask for second number or response accordingly

		- S: If wrong, repeat question (after X attempts, closes directly)

	- C: Answer

	- S: Check again depending on the expected things

		- S: If valid, compute and ask for next behavior or response accordingly

		- S: If wrong, repeat question (after X attempts, closes directly)

	- C: I'm satisfied with my care. (Ask for closing)

	- S: Good, closing connection

	- C: Exiting too

	- S: Closed

- When msg received: int/enum answerFromOppositeParty();

Specifics elements

	- Supported operations:

		- BOO: ;)

		- Let's start computing..: Start a compute operation

			- 0-9: Number to compute

			- +,-,*,/: Operators for computing

			- NEW: Reset operator, otherwise, the computation use the previous value computed as first number

			- STOP: Stop actual computing

		- I'm satisfied with my care: Launch the end of connection

		- HI:


