CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

cd student-submission

if ! [[ -f ListExamples.java ]]
then
  echo "ListExamples.java not found"
  exit
fi
cp ../TestListExamples.java ./
mkdir lib
cp -R ../lib ./

javac -cp $CPATH *.java 2>error.txt

if ! [[ $? -eq 0 ]]
then
  echo "compile error"
  exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > out.txt

grep -q FAILURES out.txt

if [[ $? -eq 0 ]]
then
  echo "failed"
else
  echo "passed"
fi

