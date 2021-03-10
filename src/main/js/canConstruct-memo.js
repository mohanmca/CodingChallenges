
const canConstruct = (target, words, memo={}) => {
    if(target === '') return true;
    if(target in memo) return true;
    for(let word of words) {
        if(target.startsWith(word)) {
            //let suffix = target.slice(word.length)
            let suffix = target.substring(word.length)
            if(canConstruct(suffix, words, memo)) {
                memo[target] = true;
                return memo[target];
            }
        }
    }
    memo[target] = false;
    return memo[target];
}

console.log(canConstruct('abcdef', ['ab', 'abc', 'cd', 'def', 'abcd']))
console.log(canConstruct('skateabcdefg', ['ab', 'abc', 'cd', 'def', 'abcd','ska','te','bo']))
console.log(canConstruct('eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef', ['e', 'ee', 'eee', 'eeee', 'eeeee','eeeeee','te','bo']))
console.log(canConstruct('impossible', ['ab', 'abc', 'cd', 'def', 'abcd']))