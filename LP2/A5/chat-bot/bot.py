import random
import re

responses = {
    "greeting": [
        "Hello! Welcome to our restaurant registration service. How can I assist you today?", 
        "Hi there! Interested in registering your restaurant? Let me know how I can help.", 
        "Welcome! What information do you need about restaurant registration?"],
    "farewell": ["Thank you for considering our restaurant registration services. Have a great day!", "Your restaurant's success is important to us. Goodbye!", "If you have any more questions about registration, feel free to ask. Take care and goodbye!"],
    "help": ["Sure, I'm here to help with restaurant registration. What specific information are you looking for?", "How can I assist you with the registration process for your restaurant? Please let me know.", "I'm here to provide the best possible guidance for registering your restaurant. What do you need help with?"],
    "registration_process": ["To register your restaurant, you can visit our website and fill out the online registration form. Alternatively, you can visit our nearest office for in-person registration assistance.", "The registration process is straightforward. You can start by visiting our website and following the online registration steps. If you prefer in-person assistance, our local offices are ready to help."],
    "required_documents": ["For restaurant registration, you typically need to provide identification documents, business permits, and health department approvals. Make sure you have these documents ready for a smooth registration process.", "The required documents for restaurant registration usually include proof of identity, business permits, and health department approvals. Ensure you have these documents in order for a successful registration."],
    "fees_and_costs": ["The registration fees vary based on the location and type of restaurant. You can find detailed information on our website or by contacting our registration department directly.", "The registration fees and costs depend on factors such as the type and location of your restaurant. Visit our website or contact our registration department for specific details."],
    "default": ["I apologize, but I couldn't understand your request.", "Apologies, I didn't quite get that. Could you please rephrase?"],
    "appointment": ["Please call our toll-free number to schedule an appointment with our registration specialists.", "To discuss restaurant registration in detail, please call our toll-free number and schedule an appointment with our dedicated registration team."],
    "menu":["Do you serve veg, nonveg food"],
    "stars":["How many stars do you have"]
}

def respond_to_inquiry(inquiry):
    inquiry = inquiry.lower()
    if re.search(r"\b(?:hello|hi)\b", inquiry):
        return random.choice(responses["greeting"])
    elif re.search(r"\b(?:goodbye|bye)\b", inquiry):
        return random.choice(responses["farewell"])
    elif re.search(r"\b(?:help|support)\b", inquiry):
        return random.choice(responses["help"])
    elif re.search(r"\b(?:register|registration)\b", inquiry):
        return random.choice(responses["registration_process"])
    elif re.search(r"\b(?:documents|papers)\b", inquiry):
        return random.choice(responses["required_documents"])
    elif re.search(r"\b(?:fees|costs)\b", inquiry):
        return random.choice(responses["fees_and_costs"])
    elif re.search(r"\b(?:when|appointment|schedule)\b", inquiry):
        return random.choice(responses["appointment"])
    elif re.search(r"\b(?:stars)\b", inquiry):
        return random.choice(responses["stars"])
    elif re.search(r"\b(?:menu|serve)\b", inquiry):
        return random.choice(responses["menu"])
    else:
        return random.choice(responses["default"])
