import enchant

class SpellChecker:
    def __init__(self, dictType) -> None:
        self.d = enchant.Dict(dictType)
        print("object created")

    def addWords(self, fileName):
        with open(fileName) as f:
            self.en_new_words = f.read().split("\n")
            print(f"Inserting {len(self.en_new_words)} words: {self.en_new_words[:5]}")
            for word in self.en_new_words:
                self.d.add(word)

    def isCorrect(self, word) -> bool:
        return self.d.check(word)

    def suggest(self, word) -> list:
        return self.d.suggest(word)

# Example usage
spell_checker = SpellChecker("en_US")
spell_checker.addWords("spell/glossary.txt")

word = "Jugad"
try:
    if spell_checker.isCorrect(word):
        print(f"Word status: Correct")
    else:
        print(f"Word status: Incorrect")
        print(f"Suggestions: {spell_checker.suggest(word)}")
except Exception as e:
    print(f"An error has occurred: {e}")
