from flask import Flask, jsonify, request, render_template
from bot import respond_to_inquiry

app = Flask(__name__)

@app.route('/query', methods=['GET'])
def query():
    query_param = request.args.get('query', '')
    result = response_to_query(query_param)
    return jsonify({"result": result})

def response_to_query(query):
    return respond_to_inquiry(query)

@app.route('/', methods = ['GET'])
def test():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)
