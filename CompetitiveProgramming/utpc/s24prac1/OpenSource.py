import sys
from operator import itemgetter

io = sys.stdin.read().splitlines()
line = 0
while True:
	proj_to_student = {}
	student_to_proj = {}
	curr_proj = ""
	while io[line] != "1":
		if io[line][0].isupper():
			proj_name = io[line]
			proj_to_student[proj_name] = set()
			curr_proj = proj_name
		else:
			student_id = io[line]
			if student_id in student_to_proj:
				if student_to_proj[student_id] != 'a' and student_to_proj[student_id] != curr_proj:
					proj_to_student[student_to_proj[student_id]].remove(student_id)
					student_to_proj[student_id] = 'a'
			else:
				proj_to_student[curr_proj].add(student_id)
				student_to_proj[student_id] = curr_proj
		line += 1
	output = []
	for proj in proj_to_student:
		output.append((proj, len(proj_to_student[proj])))
	output.sort(key=itemgetter(0))
	output.sort(key=itemgetter(1), reverse=True)
	for proj in output:
		print(f"{proj[0]} {proj[1]}")
	line += 1
	if io[line] == "0":
		break