all: build lib
	javac\
	   -d build \
	   -classpath src:../bouncycastle/lib/bcprov-ds.jar \
	   `find src -name "*.java"`
	cd build; jar -cvf bcprov-ds-ext.jar org
	mv build/bcprov-ds-ext.jar lib

build:
	mkdir -p build

lib:
	mkdir -p lib

clean:
	rm -rf build
	rm -rf lib
