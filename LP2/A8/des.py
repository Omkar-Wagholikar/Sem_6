p_box=[
    57,49,41,33,25,17,9,
    1,58,50,42,34,26,18,
    10,2,59,51,43,35,27,
    19,11,3,60,52,44,36,
    63,55,47,39,31,23,15,
    7,62,54,46,38,30,22,
    14,6,61,53,45,37,29,
    21,13,5,28,20,12,4
]

#       C:0  1  2  3  4  5  6  7  8  9  0  1  2  3  4  5  6
shifts = [0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1]

def permute(input_bits:list):
    output_bits = []
    for i in range(len(p_box)):
        try:
            output_bits.append(input_bits[p_box[i]-1])
        except:
            print(f"{i}th index error in p box")
    return output_bits[:len(output_bits) // 2], output_bits[len(output_bits) // 2:]

temp = "00010011 00110100 01010111 01111001 10011011 10111100 11011111 11110001"

a = "0001001100110100010101110111100110011011101111001101111111110001"
input_bits = list(map(int, list(a)))

print(input_bits[3])
c0, d0 = permute(input_bits)
print(c0, d0)

all_keys = []

