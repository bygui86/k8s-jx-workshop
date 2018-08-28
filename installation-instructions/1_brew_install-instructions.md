
# Homebrew 

## Installation instructions

1. Open a terminal

2. Type following command

		/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

---

## **[optional]** Modify access rights

* Homebrew root folder

		sudo chown -RL $(whoami):admin /usr/local/Homebrew

* Packages folder

		sudo chown -RL $(whoami):admin /usr/local/Cellar

* Cask folder

		sudo chown -RL $(whoami):admin /usr/local/Caskroom

* Other important folders

		sudo chown -RL $(whoami):admin /usr/local/bin
		sudo chown -RL $(whoami):admin /usr/local/share

* **[obsolete]** Modify flags of Homebrew root folders

		chflags norestricted /usr/local/Homebrew
		chflags norestricted /usr/local/Cellar
		chflags norestricted /usr/local/Caskroom

---

## Update

	brew update

---

## Links

* https://brew.sh/
