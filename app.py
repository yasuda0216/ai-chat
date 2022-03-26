from flask import Flask
from flask import jsonify
import json
import numpy as np
import openai

openai.api_key = "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"
app = Flask(__name__)
app.config['JSON_AS_ASCII'] = False

@app.route("/")
def hello_world():
  return "Hello, World!"


@app.route('/<test>')
def getinfo(test):
    
    YOUR_PROMPT = test

    model_name = "curie:ft-nagoya-institute-of-technology-2021-12-13-07-20-15"
    response = openai.Completion.create(
        model= model_name,
        prompt=YOUR_PROMPT,
        max_tokens = 200,
        stop = ["END"],
    )

    slot_extraction = response['choices'][0]['text']

    ###########################################################################################################
    whom_extraction = slot_extraction[slot_extraction.find("whom:") + 5:]
    target_extraction = slot_extraction[slot_extraction.find("target:") + 7:slot_extraction.find("\npolarity_term:")]
    polarityTerm_extraction = slot_extraction[slot_extraction.find("polarity_term:") + 14:slot_extraction.find("\naspect:")]
    aspect_extraction = slot_extraction[slot_extraction.find("aspect:") + 7:slot_extraction.find("\nresponse:")]
    response_extraction = slot_extraction[slot_extraction.find("response:") + 9:slot_extraction.find("\nexperiencer:")]
    experiencer_extraction = slot_extraction[slot_extraction.find("experiencer:") + 12:slot_extraction.find("\npolarity:")]
    polarity_extraction = slot_extraction[slot_extraction.find("polarity:") + 9:slot_extraction.find("\nwhen:")]
    when_extraction = slot_extraction[slot_extraction.find("when:") + 5:slot_extraction.find("\nwhere:")]
    where_extraction = slot_extraction[slot_extraction.find("where:") + 6:slot_extraction.find("\nwhom:")]

    info = {"target":target_extraction, "polarityTerm":polarityTerm_extraction, "aspect":aspect_extraction, 
            "response":response_extraction,"experiencer":experiencer_extraction, "polarity":polarity_extraction, 
            "when":when_extraction, "where":where_extraction, "whom":whom_extraction}
    
    return jsonify(info)